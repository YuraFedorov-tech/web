package ru.yura.db.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.yura.db.dao.UserDao;
import ru.yura.db.dao.UserDaoJdbcImpl;
import ru.yura.db.dao.UsersDaoJdbcTemplateImpl;
import ru.yura.db.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@WebServlet("/users")
public class UserServletWithDao extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUserName);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(dbDriverClassName);

            userDao=new UsersDaoJdbcTemplateImpl(dataSource);
          //  userDao=new UserDaoJdbcImpl(dataSource);

        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<User> users=userDao.FindAll();
       req.setAttribute("userFromServer", users);
        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req,resp );
    }
}
//public class UserServletWithDao extends HttpServlet {
//    private UserDao userDao;
//
//    @Override
//    public void init() throws ServletException {
//        Properties properties = new Properties();
//        DriverManagerDataSource dataSource =
//                new DriverManagerDataSource();
//        try {
//            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
//            String dbUrl = properties.getProperty("db.url");
//            String dbUserName = properties.getProperty("db.username");
//            String dbPassword = properties.getProperty("db.password");
//            String dbDriverClassName = properties.getProperty("db.driverClassName");
//
//            dataSource.setUsername(dbUserName);
//            dataSource.setPassword(dbPassword);
//            dataSource.setUrl(dbUrl);
//            dataSource.setDriverClassName(dbDriverClassName);
//
//            userDao=new UserDaoJdbcImpl(dataSource);
//
//
//        } catch (IOException e) {
//            throw new IllegalStateException();
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       List<User> users=userDao.FindAll();
//       req.setAttribute("userFromServer", users);
//        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req,resp );
//    }
//}
