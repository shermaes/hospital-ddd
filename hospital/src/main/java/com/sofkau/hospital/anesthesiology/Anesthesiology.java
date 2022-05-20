package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.anesthesiology.values.ANDirector;
import com.sofkau.hospital.anesthesiology.values.AnesthesiologyID;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anesthesiology extends AggregateEvent<AnesthesiologyID> {

    protected ANDirector anDirector;
    protected Set<Anesthesiologist> anesthesiologists;
    protected Set<Nurse> nurses;
    protected Set<Anesthesia> anesthesias;

    //creating the aggregate
    public Anesthesiology(AnesthesiologyID entityId, ANDirector anDirector) {
        super(entityId);
        appendChange(new AnesthesiologyCreated(anDirector)).apply();
    }
    private Anesthesiology(AnesthesiologyID entityId){
        super(entityId);
        subscribe(new AnesthesiologyChange(this));
    }

    public static Anesthesiology from(AnesthesiologyID entityId, List<DomainEvent> events){
        Anesthesiology anesthesiology = new Anesthesiology(entityId);
        events.forEach((event) -> anesthesiology.applyEvent(event));
        return anesthesiology;
    }

    //commands


    //getters
    public ANDirector getAnDirector() {
        return anDirector;
    }

    public Set<Anesthesiologist> getAnesthesiologist() {
        return anesthesiologists;
    }

    public Set<Nurse> getNurse() {
        return nurses;
    }

    public Set<Anesthesia> getAnesthesia() {
        return anesthesias;
    }
}
