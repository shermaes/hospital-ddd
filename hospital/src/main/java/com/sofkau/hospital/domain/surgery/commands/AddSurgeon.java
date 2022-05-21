package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.SurgeryRoom;
import com.sofkau.hospital.domain.surgery.values.SurgeonID;

public class AddSurgeon extends Command {
    private final SurgeonID entityId;
    private final SurgeryRoom surgeryRoom;

    public AddSurgeon(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        this.entityId = entityId;
        this.surgeryRoom = surgeryRoom;
    }

    public SurgeonID getEntityId() {
        return entityId;
    }

    public SurgeryRoom getSurgeryRoom() {
        return surgeryRoom;
    }
}