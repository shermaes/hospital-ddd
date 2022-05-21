package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.commands.ChangeProcedure;

public class ChangeProcedureUseCase extends UseCase<RequestCommand<ChangeProcedure>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ChangeProcedure> changeProcedureRequestCommand) {
        var command = changeProcedureRequestCommand.getCommand();
        var surgery = Surgery.from(command.getSurgeryId(), retrieveEvents(command.getSurgeryId().value()));
        surgery.changeProcedure(command.getProcedure());

        emit().onResponse(new ResponseEvents(surgery.getUncommittedChanges()));
    }
}
