package com.sofkau.hospital.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.anesthesiology.values.Brand;
import com.sofkau.hospital.anesthesiology.values.ExpiryDate;

public class AddAnesthesia extends Command  {
    private final AnesthesiaID entityId;
    private final ExpiryDate expiryDate;
    private final Brand brand;

    public AddAnesthesia(AnesthesiaID entityId, ExpiryDate expiryDate, Brand brand) {
        this.entityId = entityId;
        this.expiryDate = expiryDate;
        this.brand = brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public Brand getBrand() {
        return brand;
    }
}
