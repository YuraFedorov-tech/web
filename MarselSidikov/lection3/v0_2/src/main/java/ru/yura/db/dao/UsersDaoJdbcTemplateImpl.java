package ru.yura.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDaoJdbcTemplateImpl implements UserDao {
    private JdbcTemplate template;
    //language=SQL
    private final String SQL_SELECT_ALL =
            "SELECT * FROM fix_user";


    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> FindAllByFirstName() {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
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
     //   return null;
       return template.query(SQL_SELECT_ALL, userRowMapper );
    }

private RowMapper<User> userRowMapper= (resultSet, i) -> {
      return  new User(resultSet.getInt("id"),
              resultSet.getString("first_name"),
              resultSet.getString("last_name"));
};
}
