package com.sofkau.hospital.domain.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.values.NurseID;
import com.sofkau.hospital.domain.anesthesiology.values.Uniform;

public class NurseAdded extends DomainEvent {

    private final Uniform uniform;
    private final NurseID entityId;

    //constructor
    public NurseAdded(NurseID entityId, Uniform uniform) {
        super("SherMaestre.anesthesiology.NurseAdded");
        this.uniform = uniform;
        this.entityId = entityId;
    }

    //getter
    public Uniform getUniform() {
        return uniform;
    }

    public NurseID getEntityId() {
        return entityId;
    }

}
