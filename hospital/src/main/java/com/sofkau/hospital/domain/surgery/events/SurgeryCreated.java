package com.sofkau.hospital.domain.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class SurgeryCreated extends DomainEvent {

    private final Procedure procedure;

    public SurgeryCreated(SurgeryID entityId, Procedure procedure) {
        super("shermaestre.surgery.SurgeryCreated");
        this.procedure = procedure;
    }

    //getter

    public Procedure getProcedure() {
        return procedure;
    }
}
