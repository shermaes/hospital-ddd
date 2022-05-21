package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class SurgeryCreated extends DomainEvent {

    private final Procedure procedure;

    public SurgeryCreated(Procedure procedure) {
        super("SherMaestre.Surgery.SurgeryCreated");
        this.procedure = procedure;
    }

    //getter

    public Procedure getProcedure() {
        return procedure;
    }
}
