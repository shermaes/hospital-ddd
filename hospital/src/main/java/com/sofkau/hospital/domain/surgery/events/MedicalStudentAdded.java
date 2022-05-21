package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.MedicalStudentID;
import com.sofkau.hospital.domain.surgery.values.HeadDoctor;
import com.sofkau.hospital.domain.surgery.values.Year;

public class MedicalStudentAdded extends DomainEvent {

    private final MedicalStudentID entityId;
    private final HeadDoctor headDoctor;
    private final Year year;

    public MedicalStudentAdded(MedicalStudentID entityId, HeadDoctor headDoctor, Year year) {
        super("SherMaestre.anesthesiology.MedicalStudentAdded");
        this.entityId = entityId;
        this.headDoctor = headDoctor;
        this.year = year;
    }

    public MedicalStudentID getEntityId() {
        return entityId;
    }

    public HeadDoctor getHeadDoctor() {
        return headDoctor;
    }

    public Year getYear() {
        return year;
    }
}
