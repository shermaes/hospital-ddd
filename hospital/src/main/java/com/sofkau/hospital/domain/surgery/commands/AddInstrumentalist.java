package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.Area;
import com.sofkau.hospital.domain.surgery.values.HeadSurgeon;
import com.sofkau.hospital.domain.surgery.values.InstrumentalistID;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class AddInstrumentalist extends Command {
    private final SurgeryID surgeryId;
    private final InstrumentalistID entityId;
    private final HeadSurgeon headSurgeon;
    private final Area area;


    public AddInstrumentalist(SurgeryID surgeryId, InstrumentalistID entityId, HeadSurgeon headSurgeon, Area area) {
        this.surgeryId = surgeryId;
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

    public SurgeryID getSurgeryId() {
        return surgeryId;
    }
}
