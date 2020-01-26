package ru.yura.db.servlets;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.yura.db.dao.UserDao;
import ru.yura.db.dao.UserDaoJDBCimpl;
import ru.yura.db.dao.UserJdbcTemplateDao;
import ru.yura.db.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/usersSee")
public class UserServletWithDao extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        Properties properties=new Properties();
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        try {
        //    properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            userDao=new UserJdbcTemplateDao(dataSource);
        } catch (IOException e) {
            throw new IllegalStateException();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Optional<User> user=userDao.find(1);
      int y=0;


        List <User> users=null;
        if(req.getParameter("first_name")!=null){
            String first_name=req.getParameter("first_name");
           users=userDao.findAllByFirstName(first_name);
       }else{
        users=userDao.findAll();
        }

        req.setAttribute("usersInJDBC", users);
        req.getServletContext().getRequestDispatcher("/jsp/seeUsers.jsp").forward(req,resp );
    }
}
