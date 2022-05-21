package com.sofkau.hospital.domain.anesthesiology.values;

import co.com.sofka.domain.generic.Identity;

public class AnesthesiaID extends Identity {
    //constructors
    private AnesthesiaID(String vvid) {
        super(vvid);
    }

    public AnesthesiaID() {
    }

    public static AnesthesiaID of(String id) {
        return new AnesthesiaID(id);
    }

    {
    }
}
