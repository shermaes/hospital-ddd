package com.sofkau.hospital.surgery.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;

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
