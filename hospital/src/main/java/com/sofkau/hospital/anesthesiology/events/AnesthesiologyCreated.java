package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.ANDirector;

public class AnesthesiologyCreated extends DomainEvent {

    private final ANDirector anDirector;

    public AnesthesiologyCreated(ANDirector anDirector){
        super("shermaestre.anesthesiology.anesthesiologycreated");
        this.anDirector= anDirector;

    }

    //getters

    public ANDirector getAnDirector() {
        return anDirector;
    }
}
