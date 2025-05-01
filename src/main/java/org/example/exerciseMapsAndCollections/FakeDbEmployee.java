package org.example.exerciseMapsAndCollections;

import org.example.exerciseMapsAndCollections.entities.employee.Employee;
import org.example.exerciseMapsAndCollections.entities.employee.EmployeeRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FakeDbEmployee implements EmployeeRepository {
    private static final Map<Employee, String> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public String create(Employee employee) {
        idCounter++;
        employee.setId(String.valueOf(idCounter));
        db.put(employee, employee.getId());
        return employee.getId();
    }

    @Override
    public Optional<Employee> findOne(String key) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Employee type) {
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        return false;
    }

    @Override
    public boolean delete(Employee type) {
        return false;
    }
}
