package com.sofkau.hospital.surgery.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.surgery.values.Procedure;



public class ProcedureChanged extends DomainEvent {

    private final Procedure procedure;

    public ProcedureChanged(Procedure procedure) {
        super("SherMaestre.surgery.ProcedureChanged");
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}
