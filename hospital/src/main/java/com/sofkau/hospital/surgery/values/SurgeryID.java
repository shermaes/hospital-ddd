package com.sofkau.hospital.surgery.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;

public class SurgeryID extends Identity {
    //constructors
    private SurgeryID(String vvid){
        super(vvid);
    }

    public SurgeryID(){
    }

    public static SurgeryID of(String id){
        return new SurgeryID(id);
    }{
    }
}
