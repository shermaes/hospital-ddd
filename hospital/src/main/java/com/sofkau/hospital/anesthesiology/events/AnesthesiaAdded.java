package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;

import com.sofkau.hospital.anesthesiology.values.Brand;
import com.sofkau.hospital.anesthesiology.values.ExpiryDate;

public class AnesthesiaAdded extends DomainEvent {
    //attributes, these are constants because they will never change, they were created in the past
    private final ExpiryDate expiryDate;
    private final Brand brand;
    private final AnesthesiaID entityId;

    public AnesthesiaAdded(AnesthesiaID entityId, ExpiryDate expiryDate, Brand brand ){
        super("SherMaestre.anesthesiology.AnesthesiaAdded");
        this.brand = brand;
        this.expiryDate =expiryDate;
        this.entityId =entityId;
    }
    //getters

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }
}
