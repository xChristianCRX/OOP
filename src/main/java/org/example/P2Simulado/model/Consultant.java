package org.example.P2Simulado.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final LinkedHashSet<Employee> subordinates;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
        this.subordinates = new LinkedHashSet<>();
    }

    @Override
    public double getComission() {
        return (getSoldValue() * 0.15) + (0.30 * subordinates.stream().mapToDouble(Employee::getComission).sum());
    }

    public void addEmployee(Employee e) {
        if(!subordinates.contains(e))
            subordinates.add(e);
    }

    public Set<Employee> getEmployees() {
        return subordinates;
    }
}
