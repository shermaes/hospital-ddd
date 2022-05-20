package com.sofkau.hospital.surgery;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.hospital.surgery.events.*;

import java.util.HashSet;

public class SurgeryChange extends EventChange {

    public SurgeryChange(Surgery surgery) {
        //welcome lambda! here we are hearing the events
        apply((SurgeryCreated event) -> {
            surgery.procedure = event.getProcedure();
            surgery.surgeons = new HashSet<>();
            surgery.instrumentalists = new HashSet<>();
            surgery.medicalStudents = new HashSet<>();
        });

        apply((SurgeonAdded event)->{
            var numberOfSurgeons = surgery.getSurgeons().size();
            if (numberOfSurgeons>10){
                throw new IllegalArgumentException("You can't create more than 10 surgeons");
            }
            surgery.surgeons.add(new Surgeon(event.getEntityId(), event.getSurgeryRoom()));
        });

        apply((InstrumentalistAdded event)->{
            var numberOfInstrumentalists = surgery.getInstrumentalists().size();
            if (numberOfInstrumentalists>10){
                throw new IllegalArgumentException("You can't create more than 10 instrumentalists");
            }
            surgery.instrumentalists.add(new Instrumentalist(event.getEntityId(), event.getHeadSurgeon(), event.getArea()));
        });

        apply((MedicalStudentAdded event)->{
            var numberOfMedicalStudents = surgery.getMedicalStudents().size();
            if (numberOfMedicalStudents>4){
                throw new IllegalArgumentException("You can't create more than 4 medical students");
            }
            surgery.medicalStudents.add(new MedicalStudent(event.getEntityId(), event.getHeadDoctor(), event.getYear()));
        });

        apply((ProcedureChanged event) -> surgery.procedure = event.getProcedure());


        apply((InstrumentalistAreaUpdated event) -> {
            //getting the instrumentalist that im going to change
            var function = surgery.getInstrumentalistById((event.getEntityId()))
                        .orElseThrow(() -> new IllegalArgumentException("We did not find any Instrumentalist"));
            function.updateArea(event.getArea());
        });

        apply((InstrumentalistHeadSurgeonChanged event) -> {
            //getting the instrumentalist that im going to change
            var function = surgery.getInstrumentalistById((event.getEntityId()))
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Instrumentalist"));
            function.changeHeadSurgeon(event.getHeadSurgeon());
        });

        apply((MedicalStudentHeadDoctorUpdated event) -> {
            //getting the instrumentalist that im going to change
            var function = surgery.getMedicalStudentById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Medical Student"));
            function.updateHeadDoctor(event.getHeadDoctor());
        });

        apply((MedicalStudentYearUpdated event) -> {
            //getting the instrumentalist that im going to change
            var function = surgery.getMedicalStudentById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Medical Student"));
            function.updateYear(event.getYear());
        });

        apply((SurgeonSurgeryRoomChanged event) -> {
            //getting the instrumentalist that im going to change
            var function = surgery.getSurgeonById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Surgeon"));
            function.changeSurgeryRoom(event.getSurgeryRoom());
        });

}}
