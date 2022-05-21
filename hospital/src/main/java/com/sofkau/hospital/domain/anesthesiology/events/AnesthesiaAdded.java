package com.sofkau.hospital.domain.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;

import com.sofkau.hospital.domain.anesthesiology.values.Brand;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;

public class AnesthesiaAdded extends DomainEvent {
    //attributes, these are constants because they will never change, they were created in the past
    private final Storage expiryDate;
    private final Brand brand;
    private final AnesthesiaID entityId;

    public AnesthesiaAdded(AnesthesiaID entityId, Storage expiryDate, Brand brand) {
        super("SherMaestre.anesthesiology.AnesthesiaAdded");
        this.brand = brand;
        this.expiryDate = expiryDate;
        this.entityId = entityId;
    }
    //getters

    public Storage getExpiryDate() {
        return expiryDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }
}
