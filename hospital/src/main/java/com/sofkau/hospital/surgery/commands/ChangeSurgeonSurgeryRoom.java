package com.sofkau.hospital.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.surgery.values.SurgeonID;
import com.sofkau.hospital.surgery.values.SurgeryRoom;

public class ChangeSurgeonSurgeryRoom extends Command {

    private final SurgeonID entityId;
    private final SurgeryRoom surgeryRoom;

    public ChangeSurgeonSurgeryRoom(SurgeonID entityId, SurgeryRoom surgeryRoom) {
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
