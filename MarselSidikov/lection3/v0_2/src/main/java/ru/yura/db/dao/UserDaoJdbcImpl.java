package ru.yura.db.dao;

import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoJdbcImpl implements UserDao {

    //language=SQL
    private final String SQL_SELECT_ALL =
            "SELECT * FROM fix_user";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM fix_user WHERE id=?";
    private Connection connection;

    public UserDaoJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> FindAllByFirstName() {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("lasat_name");
                return Optional.of(new User(id, firstName, lastName));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void safe(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> FindAll() {
        try {
            List<User> users = new ArrayList<>();
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
            throw new IllegalStateException(e);
        }
    }


}
