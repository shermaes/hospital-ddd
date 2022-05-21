package com.sofkau.hospital.domain.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;

public class CreateSurgery extends Command {
    private final Procedure procedure;
    private final SurgeryID entityId;

    public CreateSurgery(SurgeryID entityId,Procedure procedure) {
        this.entityId = entityId;
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public SurgeryID getEntityId() {
        return entityId;
    }
}
