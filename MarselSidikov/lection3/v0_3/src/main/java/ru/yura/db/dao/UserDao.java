package ru.yura.db.dao;

import ru.yura.db.models.User;

import java.util.List;

public interface UserDao extends CardDao<User> {
    List<User> findAllByFirstName(String firstName);
}
