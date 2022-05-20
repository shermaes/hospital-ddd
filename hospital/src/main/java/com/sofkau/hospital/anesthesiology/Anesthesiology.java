package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.events.*;
import com.sofkau.hospital.anesthesiology.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public void addAnesthesia(AnesthesiaID entityId, Storage storage, Brand brand ){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(storage);
        Objects.requireNonNull(brand);
        appendChange(new AnesthesiaAdded(entityId, storage, brand)).apply();
    }

    public void changeANDirector(ANDirector anDirector) {
        appendChange(new ANDirectorChanged(anDirector)).apply();
    }

    public void updateAnesthesiologistYearsOfExperience(AnesthesiologistID entityId, YearsOfExperience yearsOfExperience) {
        appendChange(new AnesthesiologistYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }

    public void changeNurseUniform(NurseID entityId, Uniform uniform){
        appendChange(new NurseUniformChanged(entityId, uniform)).apply();
    }

    public void updateAnesthesiaStorage(AnesthesiaID entityId, Storage storage){
       appendChange( new AnesthesiaStorageUpdated(entityId, storage)).apply();
    }

    public void updateAnesthesiaBrand(AnesthesiaID entityId, Brand brand){
        appendChange( new AnesthesiaBrandUpdated(entityId, brand)).apply();
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

    //this will pick where im going to display the changes
    protected Optional<Anesthesiologist> getAnesthesiologistById(AnesthesiologistID entityId) {
        return Anesthesiologists()
                .stream()
                .filter(anesthesiologist -> anesthesiologist.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Nurse> getNurseById(NurseID entityId) {
        return Nurses()
                .stream()
                .filter(nurse -> nurse.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Anesthesia> getAnesthesiaById(AnesthesiaID entityId) {
        return Anesthesias()
                .stream()
                .filter(nurse -> nurse.identity().equals(entityId))
                .findFirst();
    }
}
