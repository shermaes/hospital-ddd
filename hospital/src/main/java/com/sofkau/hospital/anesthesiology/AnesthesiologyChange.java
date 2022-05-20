package com.sofkau.hospital.anesthesiology;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.hospital.anesthesiology.events.AnesthesiaAdded;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologistAdded;
import com.sofkau.hospital.anesthesiology.events.AnesthesiologyCreated;
import com.sofkau.hospital.anesthesiology.events.NurseAdded;

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

        apply((AnesthesiologistAdded event)->{
            var numberOfAnesthesiologists = anesthesiology.Anesthesiologists().size();
            if (numberOfAnesthesiologists>5){
                throw new IllegalArgumentException("You can't create more than 5 anesthesiologists");
            }
            anesthesiology.anesthesiologists.add(new Anesthesiologist(event.EntityId(), event.YearsOfExperience(), event.TypeOfAnesthesia()));
        });

        apply((NurseAdded event)->{
            var numberOfNurses = anesthesiology.Nurses().size();
            if (numberOfNurses>4){
                throw new IllegalArgumentException("You can't create more than 4 nurses");
            }
            anesthesiology.nurses.add(new Nurse(event.EntityId(), event.Uniform()));
        });

        apply((AnesthesiaAdded event)->{
            var numberOfAnesthesias = anesthesiology.Anesthesias().size();
            if (numberOfAnesthesias>5){
                throw new IllegalArgumentException("You can't create more than 4 nurses");
            }
            anesthesiology.anesthesias.add(new Anesthesia(event.EntityId(), event.ExpiryDate(), event.Brand()));
        });
    }

}
