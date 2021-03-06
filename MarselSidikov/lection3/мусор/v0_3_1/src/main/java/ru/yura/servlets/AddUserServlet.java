package ru.yura.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet("/userss")
public class AddUserServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbPassword = properties.getProperty("db.password");
            String dbUserName = properties.getProperty("db.username");
            String driverClassName = properties.getProperty("db.driverClassName");
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/addUsers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lasName = req.getParameter("last_name");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fix_user (first_name, last_name) VALUES (?,?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lasName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    //    doGet(req,resp );
      resp.sendRedirect("/usersSee");

    }
}
