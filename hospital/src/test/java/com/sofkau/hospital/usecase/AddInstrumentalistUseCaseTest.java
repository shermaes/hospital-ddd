package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.surgery.commands.AddInstrumentalist;
import com.sofkau.hospital.domain.surgery.events.InstrumentalistAdded;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddInstrumentalistUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;
    @Test
    void addInstrumentalist(){
    var command  = new AddInstrumentalist(SurgeryID.of(ROOTID), InstrumentalistID.of("456asd"), new HeadSurgeon("DR Mora"), new Area("Administrative"));
    var useCase = new AddInstrumentalistUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the instrumentalist"))
                .getDomainEvents();

        var event = (InstrumentalistAdded)events.get(0);
        Assertions.assertEquals(command.getHeadSurgeon().value(), event.getHeadSurgeon().value());
        Assertions.assertEquals(command.getArea().value(), event.getArea().value());
        Mockito.verify(repository).getEventsBy(ROOTID);


    }
}
