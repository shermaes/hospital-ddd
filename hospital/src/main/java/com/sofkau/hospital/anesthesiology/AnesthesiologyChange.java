package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologyCreated;

import java.util.HashSet;

public class AnesthesiologyChange extends EventChange {
    public AnesthesiologyChange(Anesthesiology anesthesiology) {
        //welcome lambda! here we are hearing the events
        apply((AnesthesiologyCreated event) -> {
            anesthesiology.anDirector = event.getAnDirector();
            anesthesiology.anesthesiologists = new HashSet<>();
            anesthesiology.nurses = new HashSet<>();
            anesthesiology.anesthesias = new HashSet<>();
        });
    }

}
