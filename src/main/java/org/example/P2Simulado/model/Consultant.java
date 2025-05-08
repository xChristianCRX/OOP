package org.example.P2Simulado.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinates;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
        this.subordinates = new HashSet<>();
    }

    @Override
    public double getCommission() {
        return subordinates
                .stream()
                .mapToDouble(Employee::getCommission)
                .map(value -> value * 0.3)
                .reduce(getSoldValue() * 0.15, Double::sum);
    }

    public void addEmployee(Employee e) {
        subordinates.removeIf(subordinate -> subordinate.getId().equals(e.getId()));
        subordinates.add(e);
    }

    public Set<Employee> getEmployees() {
        return new HashSet<>(subordinates);
    }
}
