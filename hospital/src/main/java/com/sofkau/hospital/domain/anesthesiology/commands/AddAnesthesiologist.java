package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.TypeOfAnesthesia;
import com.sofkau.hospital.domain.anesthesiology.values.YearsOfExperience;

public class AddAnesthesiologist extends Command {

    private final AnesthesiologyID anesthesiologyId;
    private final AnesthesiologistID entityId;
    private final YearsOfExperience yearsOfExperience;
    private final TypeOfAnesthesia typeOfAnesthesia;

    public AddAnesthesiologist(AnesthesiologyID anesthesiologyId,AnesthesiologistID entityId, YearsOfExperience yearsOfExperience, TypeOfAnesthesia typeOfAnesthesia) {
        this.anesthesiologyId = anesthesiologyId;
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

    public AnesthesiologyID getAnesthesiologyId() {
        return anesthesiologyId;
    }
}
