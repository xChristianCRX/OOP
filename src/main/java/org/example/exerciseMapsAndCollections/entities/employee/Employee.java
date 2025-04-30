package org.example.exerciseMapsAndCollections.entities.employee;

import org.example.exerciseMapsAndCollections.entities.paycheck.Paycheck;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employee {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private List<Paycheck> paychecks;

    public Employee() {
    }

    public Employee(String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.paychecks = new ArrayList<>();
    }

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.paychecks = new ArrayList<>();
    }

    public double getYearsOfService(){
        Period period = Period.between(dateOfEmployment, LocalDate.now());
        return period.getYears();
    }

    public void createPaycheck(LocalDate payday) {
        this.paychecks.add(new Paycheck(payday, this.salary));
    }

    public void removePaycheck(Paycheck paycheck) {
        this.paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaychecks(){
        return paychecks.iterator();
    }

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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }

    public void setPaychecks(List<Paycheck> paychecks) {
        this.paychecks = paychecks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                ", paychecks=" + paychecks +
                '}';
    }
}
