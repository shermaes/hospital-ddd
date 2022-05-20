package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.Procedure;

import java.util.UUID;

public class SurgeryCreated extends DomainEvent {

    private final Procedure procedure;

    public SurgeryCreated(Procedure procedure) {
        super("shermaestre.surgery.SurgeryCreated");
        this.procedure = procedure;
    }

    //getter

    public Procedure getProcedure() {
        return procedure;
    }
}
