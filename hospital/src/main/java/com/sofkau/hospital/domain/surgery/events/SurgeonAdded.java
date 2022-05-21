package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.SurgeonID;
import com.sofkau.hospital.domain.surgery.values.SurgeryRoom;

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
