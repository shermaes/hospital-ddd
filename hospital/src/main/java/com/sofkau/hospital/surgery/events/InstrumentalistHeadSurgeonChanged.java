package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.HeadSurgeon;
import com.sofkau.hospital.surgery.values.InstrumentalistID;

public class InstrumentalistHeadSurgeonChanged extends DomainEvent {

    private final InstrumentalistID entityId;
    private final HeadSurgeon headSurgeon;

    public InstrumentalistHeadSurgeonChanged(InstrumentalistID entityId, HeadSurgeon headSurgeon) {
        super("SherMaestre.surgery.InstrumentalistHeadSurgeonChanged");
        this.entityId = entityId;
        this.headSurgeon = headSurgeon;
    }

    public InstrumentalistID getEntityId() {
        return entityId;
    }

    public HeadSurgeon getHeadSurgeon() {
        return headSurgeon;
    }
}
