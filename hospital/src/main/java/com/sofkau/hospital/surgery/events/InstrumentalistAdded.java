package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.Area;
import com.sofkau.hospital.surgery.values.HeadSurgeon;
import com.sofkau.hospital.surgery.values.InstrumentalistID;

public class InstrumentalistAdded extends DomainEvent {
    private final InstrumentalistID entityId;
    private final HeadSurgeon headSurgeon;
    private final Area area;

    public InstrumentalistAdded(InstrumentalistID entityId, HeadSurgeon headSurgeon, Area area) {
        super("SherMaestre.surgery.InstrumentalistAdded");
        this.entityId = entityId;
        this.headSurgeon = headSurgeon;
        this.area = area;
    }

    public InstrumentalistID getEntityId() {
        return entityId;
    }

    public HeadSurgeon getHeadSurgeon() {
        return headSurgeon;
    }

    public Area getArea() {
        return area;
    }
}
