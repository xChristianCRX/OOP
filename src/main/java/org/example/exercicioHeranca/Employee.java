package org.example.exercicioHeranca;

import java.time.LocalDate;

public sealed abstract class Employee permits FullTimeEmployee, PerHourEmployee {
    private String id;
    private String name;
    private String jobTitle;
    private LocalDate dateOfEmployment;

    public abstract double salary();
}
