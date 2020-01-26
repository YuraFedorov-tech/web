package ru.yuraForward.servletes;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @autor Fedorov Yuri
 * @Project DBExample
 */


@WebServlet("/R")
public class AddUsersServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("initAddUsersServlet");
    }
}
