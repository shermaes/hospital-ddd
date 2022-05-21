package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.commands.AddNurse;

public class AddNurseUseCase extends UseCase<RequestCommand<AddNurse>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddNurse> addNurseRequestCommand) {
        var command = addNurseRequestCommand.getCommand();
        var anesthesiology = Anesthesiology.from(command.getAnesthesiologyId(), retrieveEvents(command.getAnesthesiologyId().value()));
        anesthesiology.addNurse(command.getEntityId(), command.getUniform());

        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));
    }

}
