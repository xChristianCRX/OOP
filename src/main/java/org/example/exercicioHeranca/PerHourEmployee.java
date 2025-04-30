package org.example.exercicioHeranca;

public final class PerHourEmployee extends Employee{
    private double hourlySalary;
    private int workedHour;

    @Override
    public double salary() {
        return workedHour * hourlySalary;
    }
}
