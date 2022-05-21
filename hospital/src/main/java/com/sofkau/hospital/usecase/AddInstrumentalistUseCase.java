package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.commands.AddInstrumentalist;

public class AddInstrumentalistUseCase extends UseCase<RequestCommand<AddInstrumentalist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInstrumentalist> addInstrumentalistRequestCommand) {
        var command = addInstrumentalistRequestCommand.getCommand();
        var surgery = Surgery.from(command.getSurgeryId(), retrieveEvents(command.getSurgeryId().value()));
        surgery.addInstrumentalist(command.getEntityId(), command.getHeadSurgeon(), command.getArea());

        emit().onResponse(new ResponseEvents(surgery.getUncommittedChanges()));

    }
}
