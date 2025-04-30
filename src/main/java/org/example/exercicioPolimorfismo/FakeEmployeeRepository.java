package org.example.exercicioPolimorfismo;

import java.util.List;

public class FakeEmployeeRepository implements Repository<Employee, String>{
    private final Employee[] employees = new Employee[100];
    private static int employeesCount = 0;

    @Override
    public void register(Employee employee) {
        if(findById(employee.getId()) == null) {
            employees[employeesCount++] = employee;
        }
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}
