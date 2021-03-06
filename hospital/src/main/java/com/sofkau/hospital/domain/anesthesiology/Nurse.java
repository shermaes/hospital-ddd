package com.sofkau.hospital.domain.anesthesiology;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.domain.anesthesiology.values.NurseID;
import com.sofkau.hospital.domain.anesthesiology.values.Uniform;

import java.util.Objects;

public class Nurse extends Entity<NurseID> {
    //VO
    private Uniform uniform;

    //Constructor
    public Nurse(NurseID entityId, Uniform uniform) {
        super(entityId);
        this.uniform = uniform;
    }

    //getter
    public Uniform Uniform() {
        return uniform;
    }

    //behaviors
    public void changeUniform(Uniform uniform) {
        this.uniform = Objects.requireNonNull(uniform);
    }
}
