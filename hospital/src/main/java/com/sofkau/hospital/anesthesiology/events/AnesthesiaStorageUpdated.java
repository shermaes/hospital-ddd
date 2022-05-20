package com.sofkau.hospital.anesthesiology.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.anesthesiology.values.Storage;



public class AnesthesiaStorageUpdated extends DomainEvent {
    private final AnesthesiaID entityId;
    private final Storage storage;

    public AnesthesiaStorageUpdated(AnesthesiaID entityId, Storage storage) {
        super("SherMaestre.anesthesiology.AnesthesiaStorageUpdated");
        this.entityId = entityId;
        this.storage = storage;
    }

    public AnesthesiaID getEntityId() {
        return entityId;
    }

    public Storage getStorage() {
        return storage;
    }
}
