package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.ANDirector;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;

public class CreateAnesthesiology extends Command {

    private final AnesthesiologyID entityId;
    private final ANDirector anDirector;

    public CreateAnesthesiology(AnesthesiologyID entityId, ANDirector anDirector) {
        this.entityId = entityId;
        this.anDirector = anDirector;
    }

    public AnesthesiologyID getEntityId() {
        return entityId;
    }

    public ANDirector getAnDirector() {
        return anDirector;
    }
}
