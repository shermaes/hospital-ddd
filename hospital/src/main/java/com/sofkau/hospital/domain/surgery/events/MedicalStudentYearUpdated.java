package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.MedicalStudentID;
import com.sofkau.hospital.domain.surgery.values.Year;

public class MedicalStudentYearUpdated extends DomainEvent {

    private final MedicalStudentID entityId;
    private final Year year;

    public MedicalStudentYearUpdated(MedicalStudentID entityId, Year year) {
        super("SherMaestre.surgery.MedicalStudentYearUpdated");
        this.entityId = entityId;
        this.year = year;
    }

    public MedicalStudentID getEntityId() {
        return entityId;
    }

    public Year getYear() {
        return year;
    }
}
