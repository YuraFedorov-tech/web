package ru.Yura.Repositories;

import ru.Yura.models.User;

import java.util.List;

public interface UserRepositories {
    List<User> findAll();

    void save(User user);

    boolean isExists(String name, String password);
}
