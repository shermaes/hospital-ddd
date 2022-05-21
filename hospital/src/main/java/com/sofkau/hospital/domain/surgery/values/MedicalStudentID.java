package com.sofkau.hospital.domain.surgery.values;

import co.com.sofka.domain.generic.Identity;

public class MedicalStudentID extends Identity {
    //constructors
    private MedicalStudentID(String vvid) {
        super(vvid);
    }

    public MedicalStudentID() {
    }

    public static MedicalStudentID of(String id) {
        return new MedicalStudentID(id);
    }

    {
    }
}
