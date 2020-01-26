package servlet;

import exception.DBException;
import model.BankClient;
import service.BankClientService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getServletContext().getRequestDispatcher("/jsp/registrationPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        Long money=Long.parseLong(req.getParameter("money"));
        String message="Add client successful";
        int status=200;
            try {
                new BankClientService().addClient(new BankClient(name,password,money));
            } catch (DBException e) {
                message="Client not add";
                status=400;
            }
        resp.setStatus(status);
            req.setAttribute("message",message);
     //
        System.out.println("kdfjzklfjb");
        doGet(req,resp);
    }

}
