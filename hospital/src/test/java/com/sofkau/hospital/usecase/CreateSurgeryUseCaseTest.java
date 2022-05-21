package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.surgery.commands.CreateSurgery;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateSurgeryUseCaseTest {

    @Test
    void createSurgeryWithAllTheParameters(){
        //arrange
        var command = new CreateSurgery(
                SurgeryID.of("xxxx"),
                new Procedure("tonsil removal")
        );

        var useCase = new CreateSurgeryUseCase();

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating the surgery"))
                .getDomainEvents();

        //assert                    why is this number here?
        var event = (SurgeryCreated)events.get(0);
        Assertions.assertEquals(command.getProcedure().value(), event.getProcedure().value());
        // the command value is the input and the event value is the output
    }
}
