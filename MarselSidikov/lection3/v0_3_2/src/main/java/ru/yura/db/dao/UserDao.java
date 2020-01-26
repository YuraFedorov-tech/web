package ru.yura.db.dao;

import ru.yura.db.models.User;

import java.util.List;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */
public interface UserDao extends CardDao<User> {
    List<User> findByName();
}
