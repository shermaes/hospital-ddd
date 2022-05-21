package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.hospital.domain.surgery.Surgery;
import com.sofkau.hospital.domain.surgery.commands.AddMedicalStudent;

public class AddMedicalStudentUseCase extends UseCase<RequestCommand<AddMedicalStudent>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMedicalStudent> addMedicalStudentRequestCommand) {
        var command = addMedicalStudentRequestCommand.getCommand();
        var surgery = Surgery.from(command.getSurgeryId(), retrieveEvents(command.getSurgeryId().value()));
        surgery.addMedicalStudent(command.getEntityId(), command.getHeadDoctor(), command.getYear());

        emit().onResponse(new ResponseEvents(surgery.getUncommittedChanges()));

    }
}
