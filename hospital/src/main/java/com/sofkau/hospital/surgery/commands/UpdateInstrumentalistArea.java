package com.sofkau.hospital.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.surgery.values.Area;
import com.sofkau.hospital.surgery.values.InstrumentalistID;

public class UpdateInstrumentalistArea extends Command {

    private final InstrumentalistID entityId;
    private final Area area;

    public UpdateInstrumentalistArea(InstrumentalistID entityId, Area area) {
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
