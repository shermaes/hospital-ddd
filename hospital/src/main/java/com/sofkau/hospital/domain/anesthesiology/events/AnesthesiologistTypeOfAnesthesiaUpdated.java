package com.sofkau.hospital.domain.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.domain.anesthesiology.values.TypeOfAnesthesia;

public class AnesthesiologistTypeOfAnesthesiaUpdated extends DomainEvent {
    private final AnesthesiologistID entityId;
    private final TypeOfAnesthesia typeOfAnesthesia;

    public AnesthesiologistTypeOfAnesthesiaUpdated(AnesthesiologistID entityId, TypeOfAnesthesia typeOfAnesthesia) {
        super("SherMaestre.anesthesiology.AnesthesiologistTypeOfAnesthesiaUpdated");
        this.entityId = entityId;
        this.typeOfAnesthesia = typeOfAnesthesia;
    }

    public AnesthesiologistID getEntityId() {
        return entityId;
    }

    public TypeOfAnesthesia getTypeOfAnesthesia() {
        return typeOfAnesthesia;
    }
}
