package ru.yura.db.servletes;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.yura.db.dao.UserDao;
import ru.yura.db.dao.UserDaoGdbcTemplate;
import ru.yura.db.dao.UserDaoJDBCimpl;
import ru.yura.db.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */

@WebServlet("/user")
public class UserServletWithDao extends HttpServlet {
    private UserDao userDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/addUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addYetOneUser=req.getParameter("addYetOneUser");
        if(!addYetOneUser.isEmpty()){
            doGet(req,resp);
        }
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        Long money=Long.parseLong(req.getParameter("money"));
        if(name.isEmpty()|| password.isEmpty()||money<0){
            doGet(req,resp);
        }

        userDao.save(new User(name,password,money));
        List<User> users=new ArrayList<>();
        users=userDao.findAll();
        req.setAttribute("usersInDB",users);
        req.getServletContext().getRequestDispatcher("/jsp/seeUsers.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");


            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

           // userDao = new UserDaoJDBCimpl(dataSource);
            userDao=new UserDaoGdbcTemplate(dataSource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);

        }
    }

}
