package ru.yura.db.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao <T> {
    Optional<T> find(Integer id);
    void safe(T model);
    void update(T model);
    void delete(Integer id);
    List<T>FindAll();

}
