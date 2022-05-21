package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.surgery.commands.AddSurgeon;
import com.sofkau.hospital.domain.surgery.events.InstrumentalistAdded;
import com.sofkau.hospital.domain.surgery.events.SurgeonAdded;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeonID;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;
import com.sofkau.hospital.domain.surgery.values.SurgeryRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddSurgeonUseCaseTest {
    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;
    @Test
    void addSurgeon(){
        var command = new AddSurgeon(SurgeryID.of(ROOTID), SurgeonID.of("qwer96"),new SurgeryRoom(5));
        var useCase = new AddSurgeonUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SurgeryCreated(
                        new Procedure("tonsil removal")
                )
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the surgeon"))
                .getDomainEvents();

        var event = (SurgeonAdded)events.get(0);
        Assertions.assertEquals(command.getSurgeryRoom().value(), event.getSurgeryRoom().value());

        Mockito.verify(repository).getEventsBy(ROOTID);

    }

}
