package org.example.exerciseMapsAndCollections;

import org.example.exerciseMapsAndCollections.entities.employee.Employee;
import org.example.exerciseMapsAndCollections.entities.paycheck.Paycheck;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        var ada = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now());

        ada.createPaycheck(LocalDate.now().plusMonths(1));
        ada.createPaycheck(LocalDate.now());

        final Iterator<Paycheck> paycheckIterator = ada.iteratorPaychecks();
        while (paycheckIterator.hasNext()){
            final Paycheck paycheck = paycheckIterator.next();
            System.out.println(paycheck);
        }
    }
}
