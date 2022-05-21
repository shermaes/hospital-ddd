package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.MedicalStudentID;
import com.sofkau.hospital.domain.surgery.values.Year;

public class UpdateMedicalStudentYear extends Command {
    private final MedicalStudentID entityId;
    private final Year year;

    public UpdateMedicalStudentYear(MedicalStudentID entityId, Year year) {

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
