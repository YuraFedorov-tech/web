package ru.Yura.repositories;

import ru.Yura.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoriesInMemory implements UsersRepository {
    private List<User> users;

    public UsersRepositoriesInMemory() {
        this.users = new ArrayList<>();
        User user = new User("Yura", "qwe", LocalDate.parse("1980-04-27"));
        User user1 = new User("Oleg", "qwe", LocalDate.parse("1980-04-27"));
        User user2 = new User("Vlad", "qwe", LocalDate.now());
        users.add(user);
        users.add(user1);
        users.add(user2);
    }

   public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
