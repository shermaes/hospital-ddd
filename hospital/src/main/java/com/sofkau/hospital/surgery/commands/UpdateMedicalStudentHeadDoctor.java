package com.sofkau.hospital.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.surgery.values.HeadDoctor;
import com.sofkau.hospital.surgery.values.MedicalStudentID;

public class UpdateMedicalStudentHeadDoctor extends Command {
    private final MedicalStudentID entityId;
    private final HeadDoctor headDoctor;

    public UpdateMedicalStudentHeadDoctor(MedicalStudentID entityId, HeadDoctor headDoctor) {
        this.entityId = entityId;
        this.headDoctor = headDoctor;
    }

    public MedicalStudentID getEntityId() {
        return entityId;
    }

    public HeadDoctor getHeadDoctor() {
        return headDoctor;
    }
}
