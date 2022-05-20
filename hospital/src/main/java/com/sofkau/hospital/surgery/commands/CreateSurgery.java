package com.sofkau.hospital.surgery.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.surgery.values.Procedure;

public class CreateSurgery extends Command {
    private final Procedure procedure;

    public CreateSurgery(Procedure procedure) {
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}
