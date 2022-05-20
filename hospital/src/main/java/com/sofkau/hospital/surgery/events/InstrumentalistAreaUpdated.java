package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.Area;
import com.sofkau.hospital.surgery.values.InstrumentalistID;


public class InstrumentalistAreaUpdated extends DomainEvent {

    private final InstrumentalistID entityId;
    private final Area area;

    public InstrumentalistAreaUpdated(InstrumentalistID entityId, Area area) {
        super("SherMaestre.surgery.InstrumentalistAreaUpdated");
        this.entityId = entityId;
        this.area = area;
    }

    public InstrumentalistID getEntityId() {
        return entityId;
    }

    public Area getArea() {
        return area;
    }
}
