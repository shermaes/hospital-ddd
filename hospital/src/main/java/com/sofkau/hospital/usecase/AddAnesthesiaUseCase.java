package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.commands.AddAnesthesia;

public class AddAnesthesiaUseCase extends UseCase<RequestCommand<AddAnesthesia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAnesthesia> addAnesthesiaRequestCommand) {
        var command = addAnesthesiaRequestCommand.getCommand();
        var anesthesiology = Anesthesiology.from(command.getAnesthesiologyId(), retrieveEvents(command.getAnesthesiologyId().value()));
        anesthesiology.addAnesthesia(command.getEntityId(), command.getStorage(), command.getBrand());

        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));

    }
}
