package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class ChangeProcedure extends Command {
    private final SurgeryID surgeryId;
    private final Procedure procedure;

    public ChangeProcedure(SurgeryID surgeryId, Procedure procedure) {
        this.surgeryId = surgeryId;
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public SurgeryID getSurgeryId() {
        return surgeryId;
    }
}
