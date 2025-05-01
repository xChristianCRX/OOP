package org.example.P2Simulado.model;

import java.time.LocalDate;

public final class Reseller extends Employee {
    public Reseller(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
    }

    @Override
    public double getComission() {
        return getSoldValue() * 0.15;
    }
}
