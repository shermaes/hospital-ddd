package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class NotifySurgeryUseCase extends UseCase<TriggeredEvent<SurgeryCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<SurgeryCreated> surgeryCreatedTriggeredEvent) {
        var event = surgeryCreatedTriggeredEvent.getDomainEvent();
        var surgery = Surgery.from(SurgeryID.of(event.aggregateRootId()), this.retrieveEvents());

    }
}
