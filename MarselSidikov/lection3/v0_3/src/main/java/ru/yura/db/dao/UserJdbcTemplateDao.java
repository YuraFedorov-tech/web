package ru.yura.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.yura.db.models.Car;
import ru.yura.db.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserJdbcTemplateDao implements UserDao {

    //language=SQL
    private final String SQL_fIND_ALL = "SELECT * FROM fix_user";
    //language=SQL
    private final String SQL_FIND_BY_FIRST_NAME="SELECT * FROM fix_user WHERE first_name=?";
    //language=SQL
    private final String SQL_USERS_WITH_CARS="SELECT fix_user.*, fix_car.id as car_id, fix_car.model FROM fix_user LEFT JOIN fix_car ON fix_user.id = fix_car.owner_id WHERE fix_user.id = ?";

    private JdbcTemplate template;
    private RowMapper<User> userRowMapper= (resultSet, i) -> {
        return  new User(resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"));
    };
    private Map<Integer, User> usersMap = new HashMap<>();


    private RowMapper<User> userRowMapper2
            = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");

        if (!usersMap.containsKey(id)) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            User user = new User(id, firstName, lastName, new ArrayList<>());
            usersMap.put(id, user);
        }

        Car car = new Car(resultSet.getInt("car_id"),
                resultSet.getString("model"), usersMap.get(id));

        usersMap.get(id).getCars().add(car);

        return usersMap.get(id);
    };

    public UserJdbcTemplateDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return template.query(SQL_FIND_BY_FIRST_NAME,userRowMapper,firstName );
    }

    @Override
    public Optional<User> find(Integer id) {
        template.query(SQL_USERS_WITH_CARS, userRowMapper2, id);
        if (usersMap.containsKey(id)) {
            return Optional.of(usersMap.get(id));
        }
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

        return template.query(SQL_fIND_ALL, userRowMapper);
    }
}
