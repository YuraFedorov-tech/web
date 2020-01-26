package ru.yura.db.dao;

import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJDBCimpl implements UserDao {
    //language=SQL
    private String SQL_SELECT_ALL = "SELECT * FROM fix_user";
    private Connection connection;

    public UserDaoJDBCimpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                User user = new User(id, firstName, lastName);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException();
        }


    }
}
