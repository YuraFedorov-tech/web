package ru.Yura.reposytory;

import at.favre.lib.crypto.bcrypt.BCrypt;
import ru.Yura.Fake.FackStorage;
import ru.Yura.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserRepository {
    private List<User> users;


    @Override
    public boolean isExist(String name, String password) {
        users=FackStorage.storage().findAllUsers();
        for(User user:users ){
            if(user.getName().equals(name) ) {
                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (result.verified)
                    return true;
            }
        }
        return false;
    }

    public List<User> findAll() {
        return FackStorage.storage().findAllUsers();
    }

    public void save(User user) {
        FackStorage.storage().findAllUsers().add(user);
    }


}
