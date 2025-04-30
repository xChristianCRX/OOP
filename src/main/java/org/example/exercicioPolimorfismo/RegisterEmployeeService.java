package org.example.exercicioPolimorfismo;

public class RegisterEmployeeService{
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public void register(Employee employee) {
        repository.register(employee);
    }
}
