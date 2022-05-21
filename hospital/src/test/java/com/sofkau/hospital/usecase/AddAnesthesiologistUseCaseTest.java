package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.anesthesiology.commands.AddAnesthesiologist;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologistAdded;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.domain.anesthesiology.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddAnesthesiologistUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAnesthesiologist(){
        var command = new AddAnesthesiologist(AnesthesiologyID.of(ROOTID), AnesthesiologistID.of("01234ab"), new YearsOfExperience(5), new TypeOfAnesthesia("local anesthesia"));
        var useCase = new AddAnesthesiologistUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the anesthesiologist"))
                .getDomainEvents();

        var event = (AnesthesiologistAdded)events.get(0);
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Assertions.assertEquals(command.getTypeOfAnesthesia().value(), event.getTypeOfAnesthesia().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
