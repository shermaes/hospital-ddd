package com.sofkau.hospital.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.anesthesiology.values.TypeOfAnesthesia;

public class UpdateAnesthesiologistTypeOfAnesthesia extends Command {

    private final AnesthesiaID entityId;
    private final TypeOfAnesthesia typeOfAnesthesia;

    public UpdateAnesthesiologistTypeOfAnesthesia(AnesthesiaID entityId, TypeOfAnesthesia typeOfAnesthesia) {
        this.entityId = entityId;
        this.typeOfAnesthesia = typeOfAnesthesia;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public TypeOfAnesthesia getTypeOfAnesthesia() {
        return typeOfAnesthesia;
    }
}
