package org.example.P2Simulado.service;

import org.example.P2Simulado.exception.EntityAlreadyExistsException;
import org.example.P2Simulado.model.Consultant;
import org.example.P2Simulado.model.Employee;
import org.example.P2Simulado.model.Reseller;
import org.example.P2Simulado.persistence.Repository;

import java.time.LocalDate;
import java.util.Optional;

public class EmployeeRegistrationService {
    private Repository repository;

    public EmployeeRegistrationService(Repository repository) {
        this.repository = repository;
    }

    public String register(String id, String name, LocalDate birthDate, double soldValue, String consultantId){
        if(repository.findById(id).isPresent())
            throw new EntityAlreadyExistsException("Employee already exists");

        Optional<Employee> consultantOpt = repository.findById(consultantId);
        if(consultantOpt.isEmpty())
            throw new IllegalArgumentException("Consultant not found");

        Employee consultant = consultantOpt.get();
        if(consultant instanceof Reseller){
            Employee newConsultant = new Consultant(
                    consultant.getId(),
                    consultant.getName(),
                    consultant.getBirthDate(),
                    consultant.getSoldValue(),
                    consultant.getConsultantInCharge()
            );
            repository.update(newConsultant);
        }

        Employee reseller = new Reseller(id, name, birthDate, soldValue, consultant);
    }
}
