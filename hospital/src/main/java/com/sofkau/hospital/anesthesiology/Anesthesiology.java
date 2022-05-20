package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologistAdded;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.anesthesiology.events.NurseAdded;
import com.sofkau.hospital.anesthesiology.values.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
public void addAnesthesiologist(AnesthesiologistID entityId, YearsOfExperience yearsOfExperience, TypeOfAnesthesia typeOfAnesthesia){
    Objects.requireNonNull(entityId);
    Objects.requireNonNull(yearsOfExperience);
    Objects.requireNonNull(typeOfAnesthesia);
    appendChange(new AnesthesiologistAdded(entityId,yearsOfExperience,typeOfAnesthesia)).apply();
    //here we append this change in order to create the event / applying that event into this aggregate
}
public void addNurse(NurseID entityId, Uniform uniform){
    Objects.requireNonNull(entityId);
    Objects.requireNonNull(uniform);
    appendChange(new NurseAdded(entityId,uniform)).apply();
}
    //getters
    public ANDirector AnDirector() {
        return anDirector;
    }

    public Set<Anesthesiologist> Anesthesiologists() {
        return anesthesiologists;
    }

    public Set<Nurse> Nurses() {
        return nurses;
    }

    public Set<Anesthesia> Anesthesias() {
        return anesthesias;
    }
}
