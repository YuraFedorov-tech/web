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
import java.util.Map;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private BankClientService bankClientService ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(PageGenerator.getInstance().getPage("registrationPage.html", new HashMap<>()));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        Long money=Long.parseLong(req.getParameter("money"));
        String message="Add client successful";
        int status=200;
  //      System.out.println(money);
        try {
            if(money<=0||!bankClientService.addClient(new BankClient(name,password,money))){
                throw new DBException();
            }
        } catch (DBException e) {
            message="Client not add";
            status=400;
        }
      //  resp.setStatus(status);
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("message", message);
        resp.getWriter().println(PageGenerator.getInstance().getPage("resultPage.html", pageVariables));

        //     req.setAttribute("message",message);
        //
      //  System.out.println("kdfjzklfjb");
      //  String s2=req.getServletContext().toString();
        // resp.sendRedirect(req.getServletContext()+"/result");
      //  resp.sendRedirect(req.getContextPath() + "/result?message="+message+"&status="+status);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    @Override
    public void init() throws ServletException {
        bankClientService =  BankClientService.getInstance();
    }

}
