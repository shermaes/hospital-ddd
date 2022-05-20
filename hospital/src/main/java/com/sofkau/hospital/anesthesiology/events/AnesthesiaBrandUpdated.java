package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.anesthesiology.values.Brand;

public class AnesthesiaBrandUpdated extends DomainEvent {
    private final AnesthesiaID entityId;
    private final Brand brand;

    public AnesthesiaBrandUpdated(AnesthesiaID entityId, Brand brand) {
        super("SherMaestre.anesthesiology.AnesthesiaBrandUpdated");
        this.entityId = entityId;
        this.brand = brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
