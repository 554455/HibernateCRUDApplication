package com.umaraliev.crud.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T getById(Integer integer);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(Integer integer);


}
