package com.sofkau.hospital.domain.anesthesiology;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.hospital.domain.anesthesiology.events.*;

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

        apply((AnesthesiologistAdded event) -> {
            var numberOfAnesthesiologists = anesthesiology.getAnesthesiologists().size();
            if (numberOfAnesthesiologists > 5) {
                throw new IllegalArgumentException("You can't create more than 5 anesthesiologists");
            }
            anesthesiology.anesthesiologists.add(new Anesthesiologist(event.getEntityId(), event.getYearsOfExperience(), event.getTypeOfAnesthesia()));
        });

        apply((NurseAdded event) -> {
            var numberOfNurses = anesthesiology.getNurses().size();
            if (numberOfNurses > 4) {
                throw new IllegalArgumentException("You can't create more than 4 nurses");
            }
            anesthesiology.nurses.add(new Nurse(event.getEntityId(), event.getUniform()));
        });

        apply((AnesthesiaAdded event) -> {
            var numberOfAnesthesias = anesthesiology.getAnesthesias().size();
            if (numberOfAnesthesias > 5) {
                throw new IllegalArgumentException("You can't create more than 5 anesthesias");
            }
            anesthesiology.anesthesias.add(new Anesthesia(event.getEntityId(), event.getStorage(), event.getBrand()));
        });

        apply((ANDirectorChanged event) -> anesthesiology.anDirector = event.getAnDirector());

        apply((AnesthesiologistYearsOfExperienceUpdated event) -> {
            //getting the anesthesiologist that im going to change
            var function = anesthesiology.getAnesthesiologistById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Anesthesiologist"));
            function.updateYearsOfExperience(event.getYearsOfExperience());
        });

        apply((NurseUniformChanged event) -> {
            //getting the nurse that im going to change
            var function = anesthesiology.getNurseById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Nurse"));
            function.changeUniform(event.getUniform());
        });

        apply((AnesthesiaStorageUpdated event) -> {
            //getting the anesthesia that im going to change
            var function = anesthesiology.getAnesthesiaById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Anesthesia"));
            function.updateStorage(event.getStorage());
        });

        apply((AnesthesiaBrandUpdated event) -> {
            //getting the anesthesia that im going to change
            var function = anesthesiology.getAnesthesiaById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Anesthesia"));
            function.updateBrand(event.getBrand());
        });

        apply((AnesthesiologistTypeOfAnesthesiaUpdated event) -> {
            //getting the anesthesiologist that im going to change
            var function = anesthesiology.getAnesthesiologistById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("We did not find any Anesthesiologist"));
            function.updateTypeOfAnesthesia(event.getTypeOfAnesthesia());
        });
    }

}
