package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.NurseID;
import com.sofkau.hospital.domain.anesthesiology.values.Uniform;

public class AddNurse extends Command {
    private final AnesthesiologyID anesthesiologyId;
    private final NurseID entityId;
    private final Uniform uniform;

    public AddNurse(AnesthesiologyID anesthesiologyId, NurseID entityId, Uniform uniform) {
        this.anesthesiologyId = anesthesiologyId;
        this.entityId = entityId;
        this.uniform = uniform;
    }

    public NurseID getEntityId() {
        return entityId;
    }

    public Uniform getUniform() {
        return uniform;
    }

    public AnesthesiologyID getAnesthesiologyId() {
        return anesthesiologyId;
    }

}
