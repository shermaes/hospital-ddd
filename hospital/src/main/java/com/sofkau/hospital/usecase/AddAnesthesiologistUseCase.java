package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.anesthesiology.Anesthesiology;
import com.sofkau.hospital.domain.anesthesiology.commands.AddAnesthesiologist;

public class AddAnesthesiologistUseCase extends UseCase<RequestCommand<AddAnesthesiologist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAnesthesiologist> addAnesthesiologistRequestCommand) {
        var command = addAnesthesiologistRequestCommand.getCommand();
        var anesthesiology = Anesthesiology.from(command.getAnesthesiologyId(), retrieveEvents(command.getAnesthesiologyId().value()));
        anesthesiology.addAnesthesiologist(command.getEntityId(), command.getYearsOfExperience(), command.getTypeOfAnesthesia());

        emit().onResponse(new ResponseEvents(anesthesiology.getUncommittedChanges()));
    }
}
