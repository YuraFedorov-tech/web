package servlet;

import exception.DBException;
import model.BankClient;
import service.BankClientService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class RegistrationServlet extends HttpServlet {
    private BankClientService bankClientService ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator.getInstance().getPage("registrationPage.html", new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        Long money=Long.parseLong(req.getParameter("money"));
        String message="Add client successful";
        int status=200;
        try {
            bankClientService.addClient(new BankClient(name,password,money));
        } catch (DBException e) {
            message="Client not add";
            status=400;
        }
        resp.setStatus(status);
        //     req.setAttribute("message",message);
        //
        System.out.println("kdfjzklfjb");
        String s2=req.getServletContext().toString();
        // resp.sendRedirect(req.getServletContext()+"/result");
        resp.sendRedirect(req.getContextPath() + "/result?message="+message+"&status="+status);
    }
    @Override
    public void init() throws ServletException {
        bankClientService =  BankClientService.getInstance();
    }

}
