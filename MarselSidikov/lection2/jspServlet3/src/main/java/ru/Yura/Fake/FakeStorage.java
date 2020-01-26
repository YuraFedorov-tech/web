package ru.Yura.Fake;

import ru.Yura.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;
    private List<User> users;
    static{
        storage=new FakeStorage();
    }

    public FakeStorage() {
        this.users = users;
        users=new ArrayList<>();
        users.add(new User("Yura F", "qwe", LocalDate.parse("1980-04-27")));
        users.add(new User("Ruslan A", "qwe", LocalDate.parse("1979-10-14")));
        users.add(new User("Oleg G", "qwer", LocalDate.parse("1980-05-15")));
    }
    // метод, предоставляющий доступ к объекту класса
    public static FakeStorage storage() {
        return storage;
    }

    // метод, возвращающий список пользователей
    public List<User> users() {
        return users;
    }
}
