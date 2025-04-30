package org.example.exerciseMapsAndCollections;

import java.time.LocalDate;

public class Paycheck {
    private LocalDate payday;
    private double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Paycheck{" +
                "payday=" + payday +
                ", salary=" + salary +
                '}';
    }
}
