package ru.yura.db.servletes;


/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project DbExample
 *
 */


import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

//@WebServlet("/user")
public class AddUsersServlet extends HttpServlet {
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
        //    req.getServletContext().getRequestDispatcher("/jsp/addUser.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {

            properties.load(new FileInputStream(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            Class.forName(dbDriverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Long money = Long.parseLong(req.getParameter("money"));

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bank_client( name, password, money) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setLong(3, money);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
         throw new IllegalArgumentException("AddUsersServlet");
        }
        doGet(req, resp);
    }
}
