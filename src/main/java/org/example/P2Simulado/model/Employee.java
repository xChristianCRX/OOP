package org.example.P2Simulado.model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Consultant, Reseller {
    private String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;
    private Consultant consultantInCharge;

    public Employee(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInCharge = consultantInCharge;
    }

    public abstract double getComission();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public void setSoldValue(double soldValue) {
        this.soldValue = soldValue;
    }

    public Consultant getConsultantInCharge() {
        return consultantInCharge;
    }

    public void setConsultantInCharge(Consultant consultantInCharge) {
        this.consultantInCharge = consultantInCharge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", soldValue=" + soldValue +
                ", consultantInCharge=" + consultantInCharge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(soldValue, employee.soldValue) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(consultantInCharge, employee.consultantInCharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, soldValue, consultantInCharge);
    }
}
