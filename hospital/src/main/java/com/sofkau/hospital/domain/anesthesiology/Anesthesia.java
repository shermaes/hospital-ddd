package com.sofkau.hospital.domain.anesthesiology;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.Brand;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;

import java.util.Objects;


public class Anesthesia extends Entity<AnesthesiaID> {
    private Storage storage;
    private Brand brand;

    public Anesthesia(AnesthesiaID entityId, Storage storage, Brand brand) {
        super(entityId);
        this.brand = brand;
        this.storage = storage;
    }

    //getters
    public Storage ExpiryDate() {
        return storage;
    }

    public Brand Brand() {
        return brand;
    }

    //behaviors
    public void updateStorage(Storage storage) {
        this.storage = Objects.requireNonNull(storage);
    }

    public void updateBrand(Brand brand) {
        this.brand = Objects.requireNonNull(brand);
    }
}
