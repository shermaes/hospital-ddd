package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.domain.anesthesiology.values.TypeOfAnesthesia;
import com.sofkau.hospital.domain.anesthesiology.values.YearsOfExperience;

public class AddAnesthesiologist extends Command {
    private final AnesthesiologistID entityId;
    private final YearsOfExperience yearsOfExperience;
    private final TypeOfAnesthesia typeOfAnesthesia;

    public AddAnesthesiologist(AnesthesiologistID entityId, YearsOfExperience yearsOfExperience, TypeOfAnesthesia typeOfAnesthesia) {
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
        this.typeOfAnesthesia = typeOfAnesthesia;
    }

    public AnesthesiologistID getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }

    public TypeOfAnesthesia getTypeOfAnesthesia() {
        return typeOfAnesthesia;
    }
}
