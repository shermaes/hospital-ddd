package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.hospital.domain.surgery.commands.ChangeProcedure;
import com.sofkau.hospital.domain.surgery.events.ProcedureChanged;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.Procedure;
import com.sofkau.hospital.domain.surgery.values.SurgeryID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ChangeProcedureUseCaseTest {
    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeProcedure(){
        var command = new ChangeProcedure(SurgeryID.of(ROOTID), new Procedure("Tonsil Removal"));
        var useCase = new ChangeProcedureUseCase();


        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(procedureChanged());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong changing the procedure"))
                .getDomainEvents();

        var event = (ProcedureChanged)events.get(0);
        Assertions.assertEquals(command.getProcedure().value(), event.getProcedure().value());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }

    private List<DomainEvent> procedureChanged(){
     return List.of(new SurgeryCreated(new Procedure("angioplasty")));
    }
}
