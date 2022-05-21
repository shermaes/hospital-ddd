package com.sofkau.hospital.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.hospital.domain.surgery.commands.AddMedicalStudent;
import com.sofkau.hospital.domain.surgery.events.MedicalStudentAdded;
import com.sofkau.hospital.domain.surgery.events.SurgeryCreated;
import com.sofkau.hospital.domain.surgery.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddMedicalStudentUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;
    @Test
    void addMedicalStudent(){
        var command = new AddMedicalStudent(SurgeryID.of(ROOTID), MedicalStudentID.of("qwe78"), new HeadDoctor("DR Martinez"), new Year("5TH"));
        var useCase = new AddMedicalStudentUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SurgeryCreated(
                        new Procedure("tonsil removal")
                )
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the medical student"))
                .getDomainEvents();

        var event = (MedicalStudentAdded)events.get(0);
        Assertions.assertEquals(command.getHeadDoctor().value(), event.getHeadDoctor().value());
        Assertions.assertEquals(command.getYear().value(), event.getYear().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
