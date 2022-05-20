package com.sofkau.hospital.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.anesthesiology.values.YearsOfExperience;

public class UpdateAnesthesiologistYearsOfExperience extends Command {

    private final AnesthesiologyID entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateAnesthesiologistYearsOfExperience(AnesthesiologyID entityId, YearsOfExperience yearsOfExperience) {
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public AnesthesiologyID getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
