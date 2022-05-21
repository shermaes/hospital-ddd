package com.sofkau.hospital.domain.surgery.values;

import co.com.sofka.domain.generic.Identity;

public class SurgeonID extends Identity {
    //constructors
    private SurgeonID(String vvid) {
        super(vvid);
    }

    public SurgeonID() {
    }

    public static SurgeonID of(String id) {
        return new SurgeonID(id);
    }

    {
    }
}
