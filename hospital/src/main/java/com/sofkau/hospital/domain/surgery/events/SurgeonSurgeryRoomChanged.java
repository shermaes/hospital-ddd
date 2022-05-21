package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.SurgeryRoom;
import com.sofkau.hospital.domain.surgery.values.SurgeonID;

public class SurgeonSurgeryRoomChanged extends DomainEvent {

    private final SurgeonID entityId;
    private final SurgeryRoom surgeryRoom;

    public SurgeonSurgeryRoomChanged(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        super("SherMaestre.surgery.SurgeonSurgeryRoomChanged");
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
