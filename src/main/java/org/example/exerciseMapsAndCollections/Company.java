package org.example.exerciseMapsAndCollections;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private HashMap<String, Employee> employees;

    public void hire(Employee employee) {
        this.employees.put(employee.getId(), employee);
    }

    public void fire(){

    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    public Collection<Employee> getEmployees(String jobTitle) {
        return employees
                .values()
                .stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .collect(Collectors.toList());
    }

    public void pay(String employeeId) {
        employees.get(employeeId).createPaycheck(LocalDate.now());
    }

    public void increaseSalary(String employeeId, double newSalary) {
        employees.get(employeeId).setSalary(newSalary);
    }

    public double averageSalary(String jobTitle) {
        return employees
                .values()
                .stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double averageSalary(LocalDate dataInicial, LocalDate dataFinal) {
        return employees
                .values()
                .stream()
                .filter(e -> e.getPaychecks());
    }
}
