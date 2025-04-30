package org.example.exercicioHeranca;

public final class FullTimeEmployee extends Employee{
    private double monthlySalary;

    @Override
    public double salary() {
        return this.monthlySalary;
    }
}
