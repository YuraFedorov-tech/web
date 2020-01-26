package ru.yura.servlets;

import ru.yura.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Fedorov Yuri
 * @Project DB_Example
 */

@WebServlet("/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<User> list = new ArrayList<>();
  //      User user=new User(10L,"Юра", "erg@erer",100_000_000L);
 //       list.add( user);
        req.setAttribute("userInBase",list);
        req.getServletContext().getRequestDispatcher("/jsp/print.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("initPrintServlet");
    }
}
