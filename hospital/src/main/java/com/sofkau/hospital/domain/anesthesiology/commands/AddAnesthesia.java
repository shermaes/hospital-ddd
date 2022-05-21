package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.Brand;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;

public class AddAnesthesia extends Command {

    private final AnesthesiologyID anesthesiologyId;
    private final AnesthesiaID entityId;
    private final Storage storage;
    private final Brand brand;

    public AddAnesthesia(AnesthesiologyID anesthesiologyId, AnesthesiaID entityId, Storage storage, Brand brand) {
        this.anesthesiologyId = anesthesiologyId;
        this.entityId = entityId;
        this.storage = storage;
        this.brand = brand;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }

    public AnesthesiologyID getAnesthesiologyId() {
        return anesthesiologyId;
    }
    public Storage getStorage() {
        return storage;
    }
}
