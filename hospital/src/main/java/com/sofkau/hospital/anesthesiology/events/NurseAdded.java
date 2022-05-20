package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.NurseID;
import com.sofkau.hospital.anesthesiology.values.Uniform;

public class NurseAdded extends DomainEvent {

    private final Uniform uniform;
    private final NurseID entityId;
//constructor
    public NurseAdded(NurseID entityId, Uniform uniform){
        super("shermaestre.anesthesiology.UniformAdded");
        this.uniform = uniform;
        this.entityId = entityId;
    }
//getter
    public Uniform getUniform() {
        return uniform;
    }

    public NurseID getEntityId(){
        return entityId;
    }

}
