package com.sofkau.hospital.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.anesthesiology.values.Brand;

public class UpdateAnesthesiaBrand extends Command {

    private final AnesthesiaID entityId;
    private final Brand brand;

    public UpdateAnesthesiaBrand(AnesthesiaID entityId, Brand brand) {
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
