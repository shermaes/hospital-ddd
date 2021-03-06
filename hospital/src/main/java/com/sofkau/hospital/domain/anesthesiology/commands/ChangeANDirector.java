package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.ANDirector;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;

public class ChangeANDirector extends Command {

    private final AnesthesiologyID anesthesiologyID;
    private final ANDirector anDirector;

    public ChangeANDirector(AnesthesiologyID anesthesiologyID, ANDirector anDirector) {
        this.anesthesiologyID = anesthesiologyID;
        this.anDirector = anDirector;
    }
    //getters

    public ANDirector getAnDirector() {
        return anDirector;
    }

    public AnesthesiologyID getAnesthesiologyID() {
        return anesthesiologyID;
    }
}
