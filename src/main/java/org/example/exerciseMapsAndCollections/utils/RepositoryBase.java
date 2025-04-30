package org.example.exerciseMapsAndCollections.utils;

import java.util.List;
import java.util.Optional;

public interface RepositoryBase<E, K>{
    K create(E type);
    Optional<E> findOne(K key);
    List<E> findAll();
    boolean update(E type);
    boolean deleteByKey(K key);
    boolean delete(E type);
}