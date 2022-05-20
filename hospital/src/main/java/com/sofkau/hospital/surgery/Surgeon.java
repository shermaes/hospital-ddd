package com.sofkau.hospital.surgery;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.surgery.values.SurgeonID;
import com.sofkau.hospital.surgery.values.SurgeryRoom;

import java.util.Objects;

public class Surgeon extends Entity<SurgeonID> {
    private SurgeryRoom surgeryRoom;

    public Surgeon(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        super(entityId);
        this.surgeryRoom = surgeryRoom;
    }

    //getter

    public SurgeryRoom getSurgeryRoom() {
        return surgeryRoom;
    }

    //behavior
    public void changeSurgeryRoom(SurgeryRoom surgeryRoom){
        this.surgeryRoom = Objects.requireNonNull(surgeryRoom);
    }
}
