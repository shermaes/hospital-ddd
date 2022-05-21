package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.commands.ChangeANDirector;
import com.sofkau.hospital.domain.anesthesiology.events.ANDirectorChanged;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.domain.anesthesiology.values.ANDirector;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ChangeANDirectorUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeAnDirector(){
        var command = new ChangeANDirector(AnesthesiologyID.of(ROOTID), new ANDirector("Andres Martinez"));
        var useCase = new ChangeANDirectorUseCase();

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(directorChanged());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong changing the director"))
                .getDomainEvents();

        var event = (ANDirectorChanged)events.get(0);
        Assertions.assertEquals(command.getAnDirector().value(), event.getAnDirector().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
    private List<DomainEvent> directorChanged(){
        return List.of(new AnesthesiologyCreated(new ANDirector("Jose Maestre")));
    }
}
