package com.sofkau.hospital.surgery;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.hospital.surgery.events.SurgeonAdded;
import com.sofkau.hospital.surgery.events.SurgeryCreated;

import java.util.HashSet;

public class SurgeryChange extends EventChange {

    public SurgeryChange(Surgery surgery) {
        //welcome lambda! here we are hearing the events
        apply((SurgeryCreated event) -> {
            surgery.procedure = event.getProcedure();
            surgery.surgeons = new HashSet<>();
            surgery.instrumentalists = new HashSet<>();
            surgery.medicalStudents = new HashSet<>();
        });

        apply((SurgeonAdded event)->{
            var numberOfSurgeons = surgery.getSurgeons().size();
            if (numberOfSurgeons>10){
                throw new IllegalArgumentException("You can't create more than 10 surgeons");
            }
            surgery.surgeons.add(new Surgeon(event.getEntityId(), event.getSurgeryRoom()));
        });



        }

}
