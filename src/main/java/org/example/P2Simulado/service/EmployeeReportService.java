package org.example.P2Simulado.service;

import org.example.P2Simulado.model.Consultant;
import org.example.P2Simulado.model.Employee;
import org.example.P2Simulado.persistence.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeReportService {
    private final Repository<String, Employee> repository;

    public EmployeeReportService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public String reportOf(String id) {
        final Optional<Employee> maybeRoot = repository.findById(id);

        if (maybeRoot.isEmpty()) return "Report is full of emptiness";

        final Employee root = maybeRoot.get();
        String result = root.toString();

        if(root instanceof Consultant consultant) {
            result += consultant.getEmployees().stream()
                    .map(e -> reportChildren(e, 1))
                    .collect(Collectors.joining());
        };
        return result;
    }

    private String reportChildren(Employee employee, int level) {
        String result = "\n" + "\t".repeat(level) + employee;

        if(employee instanceof Consultant consultant) {
            result += consultant.getEmployees().stream()
                    .map(e -> reportChildren(e, level + 1))
                    .collect(Collectors.joining());
        }
        return result;
    }
}
