package com.sofkau.hospital.domain.anesthesiology;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.domain.anesthesiology.values.TypeOfAnesthesia;
import com.sofkau.hospital.domain.anesthesiology.values.YearsOfExperience;

import java.util.Objects;

public class Anesthesiologist extends Entity<AnesthesiologistID> {
    //VO
    private YearsOfExperience yearsOfExperience;
    private TypeOfAnesthesia typeOfAnesthesia;

    //constructor
    public Anesthesiologist(AnesthesiologistID entityId, YearsOfExperience yearsOfExperience, TypeOfAnesthesia typeOfAnesthesia) {
        super(entityId);
        this.typeOfAnesthesia = typeOfAnesthesia;
        this.yearsOfExperience = yearsOfExperience;
    }

    //getters
    public YearsOfExperience YearsOfExperience() {
        return yearsOfExperience;
    }

    public TypeOfAnesthesia TypeOfAnesthesia() {
        return typeOfAnesthesia;
    }

    //behaviors
    public void updateYearsOfExperience(YearsOfExperience yearsOfExperience) {
        this.yearsOfExperience = Objects.requireNonNull(yearsOfExperience);
    }

    public void updateTypeOfAnesthesia(TypeOfAnesthesia typeOfAnesthesia) {
        this.typeOfAnesthesia = Objects.requireNonNull(typeOfAnesthesia);
    }

}
