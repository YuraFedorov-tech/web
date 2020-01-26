package ru.yura.db.dao;

import java.util.List;
import java.util.Optional;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */
public interface CardDao <T> {
    Optional<T> find(Integer id);
    void delete (Integer id);
    void save (T model);
    void update (T model);

    List<T> findAll();
}
