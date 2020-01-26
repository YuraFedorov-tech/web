package ru.yura.app;
/*
 *
 *@Data 22.01.2020
 *@autor Fedorov Yuri
 *@project Hibernate
 *
 */


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.yura.models.Car;
import ru.yura.models.User;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/db_example");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addResource("User.hbm.xml");
        configuration.addAnnotatedClass(Car.class);
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query     query3 = session.createQuery("from User  where firstName = 'q'");
        User user= (User) query3.list().get(0);
       System.out.println(user);
       session.beginTransaction();
       session.save(new Car("shaha",user));
        session.getTransaction().commit();

        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();

        Query     query2 = session.createQuery("FROM User where firstName = '1'");
        List<User> users2 = query2.list();



     //   List<Car> car = session.createQuery("from Car car", Car.class).getResultList();
        int i = 0;
    }
}
