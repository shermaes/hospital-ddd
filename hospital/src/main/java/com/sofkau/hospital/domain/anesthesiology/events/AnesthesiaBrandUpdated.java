package com.sofkau.hospital.domain.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.Brand;

public class AnesthesiaBrandUpdated extends DomainEvent {
    private final AnesthesiologyID anesthesiologyID;
    private final AnesthesiaID entityId;
    private final Brand brand;

    public AnesthesiaBrandUpdated(AnesthesiologyID anesthesiologyID, AnesthesiaID entityId, Brand brand) {
        super("SherMaestre.anesthesiology.AnesthesiaBrandUpdated");
        this.anesthesiologyID = anesthesiologyID;
        this.entityId = entityId;
        this.brand = brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
    public AnesthesiologyID getAnesthesiologyID() { return anesthesiologyID;
    }
}
