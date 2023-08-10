package com.sbt.demo.repositories;

import java.util.List;

public interface CrudRepository<T> {
    T findById(Long id);
    List<T> findAll();
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(Long id);
}

