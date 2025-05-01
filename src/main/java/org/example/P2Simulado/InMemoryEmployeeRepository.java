package org.example.P2Simulado;

import org.example.P2Simulado.model.Employee;
import org.example.P2Simulado.persistence.Repository;
import org.example.exerciseMapsAndCollections.exceptions.EntityAlreadyExistsException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private static final Map<String, Employee> db = new LinkedHashMap<>();

    @Override
    public String save(Employee entity) {
        if(db.containsKey(entity.getId()))
            throw new EntityAlreadyExistsException("Employee already exists");
        db.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public boolean update(Employee entity) {
        String id = entity.getId();
        if (db.containsKey(id)) {
            db.replace(id, entity);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Employee> findById(String id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }
}
