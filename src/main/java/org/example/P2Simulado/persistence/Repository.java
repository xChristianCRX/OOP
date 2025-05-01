package org.example.P2Simulado.persistence;

import java.util.Optional;

public interface Repository <K, E>{
    String save(E entity);
    boolean update(E entity);
    Optional<E> findById(K id);

}
