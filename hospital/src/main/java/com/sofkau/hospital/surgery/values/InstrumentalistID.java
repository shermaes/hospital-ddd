package com.sofkau.hospital.surgery.values;

import co.com.sofka.domain.generic.Identity;

public class InstrumentalistID extends Identity {

    //constructors
    private InstrumentalistID(String vvid) {
        super(vvid);
    }

    public InstrumentalistID() {
    }

    public static InstrumentalistID of(String id) {
        return new InstrumentalistID(id);
    }

    {
    }
}
