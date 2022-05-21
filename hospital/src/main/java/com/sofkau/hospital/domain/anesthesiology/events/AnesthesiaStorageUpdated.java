package com.sofkau.hospital.domain.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiologyID;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;


public class AnesthesiaStorageUpdated extends DomainEvent {
    private final AnesthesiologyID anesthesiologyID;
    private final AnesthesiaID entityId;
    private final Storage storage;

    public AnesthesiaStorageUpdated(AnesthesiologyID anesthesiologyID, AnesthesiaID entityId, Storage storage) {
        super("SherMaestre.anesthesiology.AnesthesiaStorageUpdated");
        this.anesthesiologyID = anesthesiologyID;
        this.entityId = entityId;
        this.storage = storage;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Storage getStorage() {
        return storage;
    }

    public AnesthesiologyID getAnesthesiologyID() {
        return anesthesiologyID;
    }
}
