package org.example.P2Simulado.persistence;

import java.util.Optional;

public interface Repository <K, E>{
    void save(E entity);
    void update(E entity);
    Optional<E> findById(K id);
}
