package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.NurseID;
import com.sofkau.hospital.anesthesiology.values.Uniform;

public class NurseUniformChanged extends DomainEvent {

    private final NurseID entityId;
    private final Uniform uniform;

    public NurseUniformChanged(NurseID entityId, Uniform uniform) {
        super("SherMaestre.anesthesiology.NurseUniformChanged");
        this.uniform = uniform;
        this.entityId = entityId;

    }

    public Uniform getUniform() {
        return uniform;
    }

    public NurseID getEntityId() {
        return entityId;
    }
}
