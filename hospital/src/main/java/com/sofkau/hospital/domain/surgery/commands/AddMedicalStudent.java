package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.HeadDoctor;
import com.sofkau.hospital.domain.surgery.values.MedicalStudentID;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;
import com.sofkau.hospital.domain.surgery.values.Year;

public class AddMedicalStudent extends Command {

    private final SurgeryID surgeryId;
    private final MedicalStudentID entityId;
    private final HeadDoctor headDoctor;
    private final Year year;

    public AddMedicalStudent(SurgeryID surgeryId, MedicalStudentID entityId, HeadDoctor headDoctor, Year year) {
        this.surgeryId = surgeryId;
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

    public SurgeryID getSurgeryId() {
        return surgeryId;
    }
}
