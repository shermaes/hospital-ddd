package com.sofkau.hospital.surgery;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.surgery.values.HeadDoctor;
import com.sofkau.hospital.surgery.values.MedicalStudentID;
import com.sofkau.hospital.surgery.values.Year;

import java.util.Objects;

public class MedicalStudent extends Entity<MedicalStudentID> {
    private HeadDoctor headDoctor;
    private Year year;

    public MedicalStudent(MedicalStudentID entityId, HeadDoctor headDoctor, Year year) {
        super(entityId);
        this.headDoctor = headDoctor;
        this.year = year;
    }

    //getters

    public HeadDoctor getHeadDoctor() {
        return headDoctor;
    }

    public Year getYear() {
        return year;
    }

    //behaviors
    public void updateYear(Year year){
        this.year = Objects.requireNonNull(year);
    }

    public void updateHeadDoctor(HeadDoctor headDoctor){
        this.headDoctor = Objects.requireNonNull(headDoctor);
    }
}
