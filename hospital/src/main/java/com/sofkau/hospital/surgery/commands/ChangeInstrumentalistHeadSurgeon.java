package com.sofkau.hospital.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.surgery.values.HeadSurgeon;
import com.sofkau.hospital.surgery.values.InstrumentalistID;

public class ChangeInstrumentalistHeadSurgeon extends Command {
    private final InstrumentalistID entityId;
    private final HeadSurgeon headSurgeon;

    public ChangeInstrumentalistHeadSurgeon(InstrumentalistID entityId, HeadSurgeon headSurgeon) {
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
