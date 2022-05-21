package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;
import com.sofkau.hospital.domain.surgery.values.SurgeryRoom;
import com.sofkau.hospital.domain.surgery.values.SurgeonID;

public class AddSurgeon extends Command {
    private final SurgeryID surgeryId;
    private final SurgeonID entityId;
    private final SurgeryRoom surgeryRoom;


    public AddSurgeon(SurgeryID surgeryId, SurgeonID entityId, SurgeryRoom surgeryRoom) {
        this.surgeryId = surgeryId;

        this.entityId = entityId;
        this.surgeryRoom = surgeryRoom;
    }

    public SurgeryID getSurgeryId() {
        return surgeryId;
    }

    public SurgeonID getEntityId() {
        return entityId;
    }

    public SurgeryRoom getSurgeryRoom() {
        return surgeryRoom;
    }
}
