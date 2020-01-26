package ru.Yura.Repositories;

import ru.Yura.Fake.FakeStorage;
import ru.Yura.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesInMemory implements UserRepositories{


    @Override
    public List<User> findAll() {
        return FakeStorage.storage().users();
    }



    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExists(String name, String password) {
        List<User> users=this.findAll();
        for(User user: users){
            if(name.equals(user.getName()))
                if(password.equals(user.getPassword()))
                    return true;
        }
        return false;
    }
}
