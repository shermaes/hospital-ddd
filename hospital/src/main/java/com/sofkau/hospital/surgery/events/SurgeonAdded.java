package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.SurgeonID;
import com.sofkau.hospital.surgery.values.SurgeryRoom;

public class SurgeonAdded extends DomainEvent {
    private final SurgeryRoom surgeryRoom;
    private final SurgeonID entityId;

    public SurgeonAdded(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        super("SherMaestre.surgery.SurgeonAdded");
        this.surgeryRoom = surgeryRoom;
        this.entityId = entityId;
    }

    public SurgeryRoom getSurgeryRoom() {
        return surgeryRoom;
    }

    public SurgeonID getEntityId() {
        return entityId;
    }
}
