package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.commands.ChangeANDirector;

public class ChangeANDirectorUseCase extends UseCase<RequestCommand<ChangeANDirector>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeANDirector> changeANDirectorRequestCommand) {
        var command = changeANDirectorRequestCommand.getCommand();
        var anesthesiology = Anesthesiology.from(command.getAnesthesiologyID(), retrieveEvents(command.getAnesthesiologyID().value()));
        anesthesiology.changeANDirector(command.getAnDirector());

        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));

    }
}
