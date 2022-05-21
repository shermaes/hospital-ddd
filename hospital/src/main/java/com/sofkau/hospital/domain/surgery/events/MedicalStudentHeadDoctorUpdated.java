package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.HeadDoctor;
import com.sofkau.hospital.domain.surgery.values.MedicalStudentID;

public class MedicalStudentHeadDoctorUpdated extends DomainEvent {

    private final MedicalStudentID entityId;
    private final HeadDoctor headDoctor;

    public MedicalStudentHeadDoctorUpdated(MedicalStudentID entityId, HeadDoctor headDoctor) {
        super("SherMaestre.surgery.MedicalStudentHeadDoctorUpdated");
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
