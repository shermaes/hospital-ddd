package com.sofkau.hospital.domain.anesthesiology.values;

import co.com.sofka.domain.generic.Identity;

public class NurseID extends Identity {

    public NurseID() {
    }

    public NurseID(String vvid) {
        super(vvid);
    }

    public static AnesthesiologyID of(String id) {
        return new AnesthesiologyID(id);
    }


}
