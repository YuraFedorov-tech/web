package ru.yura.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;


/**
 * @autor Fedorov Yuri
 * @Project DB_Example
 */

@WebServlet("/user")
public class addUser extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
       System.out.println("initAddUser");
    }
}
