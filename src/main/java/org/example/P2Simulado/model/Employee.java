package org.example.P2Simulado.model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Consultant, Reseller {
    protected final String id;
    protected final String name;
    protected final LocalDate birthDate;
    protected final double soldValue;
    protected final Consultant consultantInCharge;

    public Employee(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInCharge = consultantInCharge;
    }

    public abstract double getCommission();

    @Override
    public String toString() {
        return String.format("[%s] %s | Birthday: %s | Amount in sales: US$%.2f | Commission: US$%.2f \n",
                id, name, birthDate, soldValue, getCommission());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public Consultant getConsultantInCharge() {
        return consultantInCharge;
    }

}
