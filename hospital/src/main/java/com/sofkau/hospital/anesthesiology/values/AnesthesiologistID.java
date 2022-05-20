package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.Identity;

public class AnesthesiologistID extends Identity {
    //constructors
        private AnesthesiologistID(String vvid){
            super(vvid);
        }

        public AnesthesiologistID(){
        }

        public static AnesthesiologistID of(String id){
            return new AnesthesiologistID(id);
        }
}
