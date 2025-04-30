package org.example.exercicioPolimorfismo;

public interface Repository <T, K>{
    void register(T entity);
    Employee findById(K key);
}
