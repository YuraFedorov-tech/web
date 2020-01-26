package ru.Yura.Fake;

import at.favre.lib.crypto.bcrypt.BCrypt;
import ru.Yura.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FackStorage {
    private static final FackStorage storage;
    private List<User> users;

    static {
        storage = new FackStorage();
    }

    private FackStorage() {
        this.users = users;
        users=new ArrayList<>();
       String password= BCrypt.withDefaults().hashToString(12, "qwe".toCharArray());
        users.add(new User("Yura F", password, LocalDate.parse("1980-04-27")));
        users.add(new User("Ruslan A", password, LocalDate.parse("1979-10-14")));
        users.add(new User("Oleg G", password, LocalDate.parse("1980-05-15")));
    }

    public static FackStorage storage() {
        return storage;
    }

    public List<User> findAllUsers() {
        return users;
    }


}
