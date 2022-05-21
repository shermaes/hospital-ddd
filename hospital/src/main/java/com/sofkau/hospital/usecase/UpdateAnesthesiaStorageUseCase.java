package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiaStorageUpdated;


public class UpdateAnesthesiaStorageUseCase extends UseCase<TriggeredEvent<AnesthesiaStorageUpdated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AnesthesiaStorageUpdated> anesthesiaStorageUpdatedTriggeredEvent) {
        var event = anesthesiaStorageUpdatedTriggeredEvent.getDomainEvent();
        var anesthesiology = Anesthesiology.from(event.getAnesthesiologyID(), retrieveEvents(event.getAnesthesiologyID().value()));
        anesthesiology.updateAnesthesiaStorage(event.getAnesthesiologyID(), event.getEntityId(), event.getStorage());
        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));
    }
}
