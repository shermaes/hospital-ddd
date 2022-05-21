package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.Brand;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;

public class AddAnesthesia extends Command {
    private final AnesthesiaID entityId;
    private final Storage storage;
    private final Brand brand;

    public AddAnesthesia(AnesthesiaID entityId, Storage storage, Brand brand) {
        this.entityId = entityId;
        this.storage = storage;
        this.brand = brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Storage getExpiryDate() {
        return storage;
    }

    public Brand getBrand() {
        return brand;
    }
}
