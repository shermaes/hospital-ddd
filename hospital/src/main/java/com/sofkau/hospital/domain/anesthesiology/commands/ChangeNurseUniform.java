package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.NurseID;
import com.sofkau.hospital.domain.anesthesiology.values.Uniform;

public class ChangeNurseUniform extends Command {

    private final NurseID entityId;
    private final Uniform uniform;

    public ChangeNurseUniform(NurseID entityId, Uniform uniform) {
        this.entityId = entityId;
        this.uniform = uniform;
    }

    public NurseID getEntityId() {
        return entityId;
    }

    public Uniform getUniform() {
        return uniform;
    }
}
