package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.AnesthesiologistID;
import com.sofkau.hospital.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.anesthesiology.values.YearsOfExperience;

public class AnesthesiologistYearsOfExperienceUpdated extends DomainEvent {
    private final AnesthesiologistID entityId;
    private final YearsOfExperience yearsOfExperience;

    public AnesthesiologistYearsOfExperienceUpdated(AnesthesiologyID entityId, YearsOfExperience yearsOfExperience) {
        super("SherMaestre.anesthesiology.AnesthesiologistYearsOfExperienceUpdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public AnesthesiologistID getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
