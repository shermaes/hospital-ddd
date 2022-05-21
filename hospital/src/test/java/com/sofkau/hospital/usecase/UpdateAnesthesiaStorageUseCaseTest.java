package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiaAdded;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiaStorageUpdated;
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
class UpdateAnesthesiaStorageUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateAnesthesiaStorage(){
        var eventPast = new AnesthesiaStorageUpdated(AnesthesiologyID.of(ROOTID), AnesthesiaID.of("ert"), new Storage(6));
        var useCase = new UpdateAnesthesiaStorageUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new AnesthesiologyCreated(new ANDirector("Andres Martinez")), new AnesthesiaAdded(AnesthesiaID.of("ert"), new Storage(7), new Brand("Farmatodo")))
        );
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(eventPast))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong changing the storage"))
                .getDomainEvents();

        var event = (AnesthesiaStorageUpdated)events.get(0);
        Assertions.assertEquals(eventPast.getStorage().value(), event.getStorage().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
        System.out.println(eventPast.getStorage().value());
        System.out.println(event.getStorage().value());
    }

}