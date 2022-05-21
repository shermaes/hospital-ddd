package com.sofkau.hospital.domain.surgery;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.events.*;
import com.sofkau.hospital.domain.surgery.values.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Surgery extends AggregateEvent<SurgeryID> {
    //attributes
    protected Procedure procedure;
    protected Set<Surgeon> surgeons;
    protected Set<Instrumentalist> instrumentalists;
    protected Set<MedicalStudent> medicalStudents;

    //creating the aggregate
    public Surgery(SurgeryID surgeryId, Procedure procedure) {
        super(surgeryId);
        appendChange(new SurgeryCreated(procedure)).apply();
    }

    private Surgery(SurgeryID surgeryId) {
        super(surgeryId);
        subscribe(new SurgeryChange(this));
    }

    public static Surgery from(SurgeryID surgeryId, List<DomainEvent> events) {
        Surgery surgery = new Surgery(surgeryId);
        events.forEach((event) -> surgery.applyEvent(event));
        return surgery;
    }
    //commands

    public void addSurgeon(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(surgeryRoom);
        appendChange(new SurgeonAdded(entityId, surgeryRoom)).apply();
    }

    public void addInstrumentalist(InstrumentalistID entityId, HeadSurgeon headSurgeon, Area area) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(headSurgeon);
        Objects.requireNonNull(area);
        appendChange(new InstrumentalistAdded(entityId, headSurgeon, area)).apply();
    }

    public void addMedicalStudent(MedicalStudentID entityId, HeadDoctor headDoctor, Year year) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(headDoctor);
        Objects.requireNonNull(year);
        appendChange(new MedicalStudentAdded(entityId, headDoctor, year)).apply();
    }

    public void changeProcedure(Procedure procedure) {
        appendChange(new ProcedureChanged(procedure)).apply();
    }

    public void updateInstrumentalistArea(InstrumentalistID entityId, Area area) {
        appendChange(new InstrumentalistAreaUpdated(entityId, area)).apply();
    }

    public void changeInstrumentalistHeadSurgeon(InstrumentalistID entityId, HeadSurgeon headSurgeon) {
        appendChange(new InstrumentalistHeadSurgeonChanged(entityId, headSurgeon)).apply();
    }

    public void updateMedicalStudentHeadDoctor(MedicalStudentID entityId, HeadDoctor headDoctor) {
        appendChange(new MedicalStudentHeadDoctorUpdated(entityId, headDoctor)).apply();
    }

    public void updateMedicalStudentYear(MedicalStudentID entityId, Year year) {
        appendChange(new MedicalStudentYearUpdated(entityId, year)).apply();
    }

    public void changeSurgeonSurgeryRoom(SurgeonID entityId, SurgeryRoom surgeryRoom) {
        appendChange(new SurgeonSurgeryRoomChanged(entityId, surgeryRoom)).apply();
    }

    //getters
    public Procedure getProcedure() {
        return procedure;
    }

    public Set<Surgeon> getSurgeons() {
        return surgeons;
    }

    public Set<Instrumentalist> getInstrumentalists() {
        return instrumentalists;
    }

    public Set<MedicalStudent> getMedicalStudents() {
        return medicalStudents;
    }

    //this will pick where im going to display the changes
    protected Optional<Surgeon> getSurgeonById(SurgeonID entityId) {
        return getSurgeons()
                .stream()
                .filter(surgeon -> surgeon.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Instrumentalist> getInstrumentalistById(InstrumentalistID entityId) {
        return getInstrumentalists()
                .stream()
                .filter(instrumentalist -> instrumentalist.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<MedicalStudent> getMedicalStudentById(MedicalStudentID entityId) {
        return getMedicalStudents()
                .stream()
                .filter(nurse -> nurse.identity().equals(entityId))
                .findFirst();
    }


}


