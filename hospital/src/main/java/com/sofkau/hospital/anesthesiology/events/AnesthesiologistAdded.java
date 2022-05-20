package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.anesthesiology.values.TypeOfAnesthesia;
import com.sofkau.hospital.anesthesiology.values.YearsOfExperience;


public class AnesthesiologistAdded extends DomainEvent {

    //VO
    private final YearsOfExperience yearsOfExperience;
    private final TypeOfAnesthesia typeOfAnesthesia;
    private final AnesthesiologistID entityId;

    //constructor
    public AnesthesiologistAdded(AnesthesiologistID entityId, YearsOfExperience yearsOfExperience, TypeOfAnesthesia typeOfAnesthesia) {
        super("SherMaestre.anesthesiology.AnesthesiologistAdded");
        this.yearsOfExperience = yearsOfExperience;
        this.typeOfAnesthesia = typeOfAnesthesia;
        this.entityId = entityId;
    }

    //getters

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }

    public TypeOfAnesthesia getTypeOfAnesthesia() {
        return typeOfAnesthesia;
    }

    public AnesthesiologistID getEntityId() {
        return entityId;
    }
}
