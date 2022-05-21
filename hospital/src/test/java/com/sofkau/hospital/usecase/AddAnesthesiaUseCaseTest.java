package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.anesthesiology.commands.AddAnesthesia;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiaAdded;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.domain.anesthesiology.events.NurseAdded;
import com.sofkau.hospital.domain.anesthesiology.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddAnesthesiaUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAnesthesia(){
        var command = new AddAnesthesia(AnesthesiologyID.of(ROOTID), AnesthesiaID.of("abcd124"), new Storage(8), new Brand("Farmacos Almendia"));
        var useCase = new AddAnesthesiaUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the anesthesia"))
                .getDomainEvents();

        var event = (AnesthesiaAdded)events.get(0);
        Assertions.assertEquals(command.getStorage().value(), event.getStorage().value());
        Assertions.assertEquals(command.getBrand().value(), event.getBrand().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
