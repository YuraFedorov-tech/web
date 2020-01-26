package ru.yura.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */
public class UserDaoGdbcTemplate implements UserDao {
    private Connection connection;
    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM bank_client";
    private Map<Long, User> userMap = new HashMap<>();
    private JdbcTemplate template;
    private RowMapper<User> rowMaper = ((resultSet, i) -> new User(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getString("password"),
            resultSet.getLong("money")
    ));

    public UserDaoGdbcTemplate(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
      //  connection=dataSource.getConnection();
    }

    public UserDaoGdbcTemplate() {
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
        String name=user.getName();
        String password=user.getPassword();
        Long money=user.getMoney();
        template.update("INSERT INTO bank_client(name, password, money) VALUES (?,?,?)",name,password,money);
    }

    @Override
    public void update(User model) {

    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_FIND_ALL,rowMaper);
    }
}
