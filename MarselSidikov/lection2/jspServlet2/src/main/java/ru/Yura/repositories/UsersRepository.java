package ru.Yura.repositories;
import ru.Yura.models.User;
import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void save(User user);
}
