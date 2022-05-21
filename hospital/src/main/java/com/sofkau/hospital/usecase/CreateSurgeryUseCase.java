package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.commands.CreateSurgery;

public class CreateSurgeryUseCase extends UseCase<RequestCommand<CreateSurgery>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateSurgery> createSurgeryRequestCommand) {
        var command = createSurgeryRequestCommand.getCommand();
        var surgery = new Surgery(
          command.getEntityId(),
          command.getProcedure()
        );
        emit().onResponse(new ResponseEvents(surgery.getUncommittedChanges()));
    }
}
