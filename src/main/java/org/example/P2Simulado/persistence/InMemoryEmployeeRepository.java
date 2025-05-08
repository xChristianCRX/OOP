package org.example.P2Simulado.persistence;

import org.example.P2Simulado.model.Consultant;
import org.example.P2Simulado.model.Employee;
import org.example.exerciseMapsAndCollections.exceptions.EntityAlreadyExistsException;

import java.util.*;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private static final Map<String, Employee> db = new LinkedHashMap<>();

    @Override
    public void save(Employee entity) {
        if (db.containsKey(entity.getId()))
            throw new EntityAlreadyExistsException("Entity with id is already registered: " + entity.getId());
        db.put(entity.getId(), entity);
    }

    @Override
    public void update(Employee entity) {
        if (db.replace(entity.getId(), entity) == null)
            throw new NoSuchElementException("Entity not found: " + entity.getId());
    }

    @Override
    public Optional<Employee> findById(String id) {
        final Collection<Employee> children = db.values().stream()
                .filter(e -> Objects.nonNull(e.getConsultantInCharge()))
                .filter(e -> e.getConsultantInCharge().getId().equals(id))
                .toList();

        Employee employee = db.get(id);

        if (children.isEmpty()) {
            return Optional.ofNullable(employee);
        }

        final Consultant consultant = (Consultant) employee;
        children.forEach(e -> consultant.addEmployee(findById(e.getId()).orElseThrow()));
        return Optional.ofNullable(consultant);
    }
}
