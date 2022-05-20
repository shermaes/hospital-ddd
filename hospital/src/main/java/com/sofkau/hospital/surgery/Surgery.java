package com.sofkau.hospital.surgery;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.events.SurgeryCreated;
import com.sofkau.hospital.surgery.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Surgery extends AggregateEvent<SurgeryID> {
    //attributes
    protected Procedure procedure;
    protected Set<Surgeon> surgeons;
    protected Set<Instrumentalist> instrumentalists;
    protected Set<MedicalStudent> medicalStudents;

    //creating the aggregate
    public Surgery(SurgeryID entityId, Procedure procedure) {
        super(entityId);
        appendChange(new SurgeryCreated(procedure)).apply();
    }

    private Surgery(SurgeryID entityId){
        super(entityId);
        subscribe(new SurgeryChange(this));
    }

    public static Surgery from(SurgeryID entityId, List<DomainEvent> events){
        Surgery surgery = new Surgery(entityId);
        events.forEach((event) -> surgery.applyEvent(event));
        return surgery;
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


   

}


