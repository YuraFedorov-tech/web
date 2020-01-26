package ru.yura.db.dao;

import ru.yura.db.models.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {
    List<User> FindAllByFirstName();
}
