package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.ANDirector;

public class ANDirectorChanged extends DomainEvent {
    private final ANDirector anDirector;

    public ANDirectorChanged(ANDirector anDirector) {
        super("SherMaestre.anesthesiology.ANDirectorChanged");
        this.anDirector = anDirector;
    }

    public ANDirector getAnDirector() {
        return anDirector;
    }
}
