package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.anesthesiology.values.*;

import java.util.Objects;

public class Anesthesia extends Entity<AnesthesiaID> {
    private ExpiryDate expiryDate;
    private Brand brand;
    public Anesthesia(AnesthesiaID entityId, ExpiryDate expiryDate, Brand brand ){
        super(entityId);
        this.brand = brand;
        this.expiryDate =expiryDate;
    }
    //getters
    public ExpiryDate ExpiryDate() {
        return expiryDate;
    }

    public Brand Brand() {
        return brand;
    }

    //behaviors
    public void addExpiryDate(ExpiryDate expiryDate){
        this.expiryDate = Objects.requireNonNull(expiryDate);
    }
    public void addBrand(Brand brand){
        this.brand = Objects.requireNonNull(brand);
    }
}
