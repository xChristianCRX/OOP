package org.example.exercicioPolimorfismo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Repository<Employee, String> repository = new FakeEmployeeRepository();

        RegisterEmployeeService registerEmployeeService = new RegisterEmployeeService(repository);
        FindEmployeeService findEmployeeService = new FindEmployeeService(repository);

        Employee a = new Employee("id01", "Chris", "Dev", 1400, LocalDate.of(2024,8,26));
        Employee b = new Employee("id02", "Jhenny", "Monitora", 4000, LocalDate.of(2025,1,20));

        registerEmployeeService.register(a);
        registerEmployeeService.register(b);
        registerEmployeeService.register(a);

        Employee employee = findEmployeeService.findById("id02");
        System.out.println(employee);
    }
}
