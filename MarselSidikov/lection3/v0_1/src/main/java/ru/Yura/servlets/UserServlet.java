package ru.Yura.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


@WebServlet("/")
public class UserServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("doGet");
        req.getServletContext().getRequestDispatcher("/jsp/addUsers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName=req.getParameter("first_name");
        String lastName=req.getParameter("last_name");
        try {
//            Statement statement=connection.createStatement();
//            String sqlInsert = "INSERT INTO fix_user(first_name, last_name)" +
//                   "VALUES('" + firstName + "','" + lastName + "');";
//            System.out.print(sqlInsert);
//            statement.execute(sqlInsert);
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO " +
                    "fix_user(first_name, last_name) VALUES (?, ?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}

