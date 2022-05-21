package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.commands.AddSurgeon;

public class AddSurgeonUseCase extends UseCase<RequestCommand<AddSurgeon>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSurgeon> addSurgeonRequestCommand) {
        var command = addSurgeonRequestCommand.getCommand();
        var surgery = Surgery.from(command.getSurgeryId(), retrieveEvents(command.getSurgeryId().value()));
        surgery.addSurgeon(command.getEntityId(), command.getSurgeryRoom());

        emit().onResponse(new ResponseEvents(surgery.getUncommittedChanges()));
    }
}
