package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.events.AnesthesiaBrandUpdated;


public class UpdateAnesthesiaBrandUseCase extends UseCase<TriggeredEvent<AnesthesiaBrandUpdated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<AnesthesiaBrandUpdated> anesthesiaBrandUpdatedTriggeredEvent) {
        var event = anesthesiaBrandUpdatedTriggeredEvent.getDomainEvent();
        var anesthesiology = Anesthesiology.from(event.getAnesthesiologyID(), retrieveEvents(event.getAnesthesiologyID().value()));
        anesthesiology.updateAnesthesiaBrand(event.getAnesthesiologyID(), event.getEntityId(), event.getBrand());
        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));
    }
}
