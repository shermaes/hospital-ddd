package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.anesthesiology.commands.AddNurse;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.domain.anesthesiology.events.NurseAdded;
import com.sofkau.hospital.domain.anesthesiology.values.ANDirector;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.NurseID;
import com.sofkau.hospital.domain.anesthesiology.values.Uniform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddNurseUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;
    @Test
    void addNurse(){
        var command = new AddNurse(AnesthesiologyID.of(ROOTID), NurseID.of("01234ad"), new Uniform("medical scrubs"));
        var useCase = new AddNurseUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new AnesthesiologyCreated(
                        new ANDirector("Andres Martinez")
                )
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the nurse"))
                .getDomainEvents();

        var event = (NurseAdded)events.get(0);
        Assertions.assertEquals(command.getUniform().value(), event.getUniform().value());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }
}
