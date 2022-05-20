package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.Identity;

public class AnesthesiologyID extends Identity {

    public AnesthesiologyID() {
    }

    public AnesthesiologyID(String vvid) {
        super(vvid);
    }

    public static AnesthesiologyID of(String id) {
        return new AnesthesiologyID(id);
    }

}
