package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.commands.CreateAnesthesiology;

public class CreateAnesthesiologyUseCase  extends UseCase<RequestCommand<CreateAnesthesiology>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateAnesthesiology> createAnesthesiologyRequestCommand) {
        var command = createAnesthesiologyRequestCommand.getCommand();
        var anesthesiology = new Anesthesiology(
                command.getEntityId(),
                command.getAnDirector()
        );
        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));
    }
}
