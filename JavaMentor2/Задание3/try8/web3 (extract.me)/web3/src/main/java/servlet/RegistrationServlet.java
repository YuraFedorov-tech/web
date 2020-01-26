package servlet;

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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private BankClientService bankClientService ;
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
        if(bankClientService.addClient(new BankClient(name,password,money))){
        } else {
            message="Client not add";
            status=400;
        }
        resp.setStatus(status);
        System.out.println("kdfjzklfjb");
        String s2=req.getServletContext().toString();
        resp.sendRedirect(req.getContextPath() + "/result?message="+message+"&status="+status);
    }
    @Override
    public void init() throws ServletException {
        bankClientService = new BankClientService();
    }
}
