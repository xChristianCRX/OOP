package org.example.P2Simulado.service;

import org.example.P2Simulado.exception.EntityAlreadyExistsException;
import org.example.P2Simulado.model.Consultant;
import org.example.P2Simulado.model.Employee;
import org.example.P2Simulado.model.Reseller;
import org.example.P2Simulado.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String consultantId) {
        Employee consultantOpt = repository.findById(consultantId).orElse(null);

        if(consultantOpt == null){
            repository.save(new Reseller(id, name, birthDate, soldValue, null));
            return;
        }

        Consultant consultant = consultantOpt instanceof Reseller
                ? ((Reseller) consultantOpt).promote()
                : (Consultant) consultantOpt;

        final Reseller newEmployee = new Reseller(id, name, birthDate, soldValue, consultant);
        consultant.addEmployee(newEmployee);

        repository.update(consultant);
        repository.save(newEmployee);
    }
}
