package com.sofkau.hospital.domain.anesthesiology.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.hospital.domain.anesthesiology.values.AnesthesiaID;
import com.sofkau.hospital.domain.anesthesiology.values.Storage;

public class UpdateAnesthesiaStorage extends Command {

    private final AnesthesiaID entityId;
    private final Storage storage;

    public UpdateAnesthesiaStorage(AnesthesiaID entityId, Storage storage) {
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
