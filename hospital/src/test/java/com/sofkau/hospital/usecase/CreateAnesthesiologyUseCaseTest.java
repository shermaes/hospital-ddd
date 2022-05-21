package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.anesthesiology.commands.CreateAnesthesiology;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.domain.anesthesiology.values.ANDirector;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class
CreateAnesthesiologyUseCaseTest {

    @Test
    void createAnesthesiologyWithAllTheParameters(){
        //arrange
        var command = new CreateAnesthesiology(
                AnesthesiologyID.of("XXXX"),
                new ANDirector("Andres Arritvixaga")
        );

        var useCase = new CreateAnesthesiologyUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrongn creating anesthesiology department"))
                .getDomainEvents();

        var event = (AnesthesiologyCreated)events.get(0);
        Assertions.assertEquals(command.getAnDirector().value(), event.getAnDirector().value());
    }
}
