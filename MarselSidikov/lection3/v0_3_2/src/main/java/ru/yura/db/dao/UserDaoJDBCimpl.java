package ru.yura.db.dao;

import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */
public class UserDaoJDBCimpl implements UserDao {
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM bank_client";
    private Connection connection;

    public UserDaoJDBCimpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalArgumentException("UserDaoJDBCimpl constructor");
        }
    }

    @Override
    public List<User> findByName() {
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
    public void save(User user) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bank_client( name, password, money) VALUES (?,?,?)")){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMoney());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException("UserDaoJDBCimpl save");
        }

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
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Long money = resultSet.getLong("money");
                User user = new User(id, name, password, money);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("UserDaoJDBCimpl findAll");
        }

        return users;
    }
}
