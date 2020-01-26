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

@WebServlet("/transaction")
public class MoneyTransactionServlet extends HttpServlet {

    private BankClientService bankClientService ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    PageGenerator.getInstance().getPage("moneyTransactionPage.html", new HashMap<>());
        req.getServletContext().getRequestDispatcher("/jsp/moneyTransaktionPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderName = req.getParameter("senderName");
        String senderPass = req.getParameter("senderPass");
        Long money = Long.parseLong(req.getParameter("count"));
        String nameTo = req.getParameter("nameTo");
        String message = "The transaction was successful";
        int status = 200;
        if(  bankClientService.sendMoneyToClient(new BankClient(senderName,senderPass),nameTo,money)){
        } else {
            message = "transaction rejected";
            status = 400;
        }
        resp.setStatus(status);
        System.out.println("kdfjzklfjb");
        resp.sendRedirect(req.getContextPath() + "/result?message="+message+"&status="+status);
    }

    @Override
    public void init() throws ServletException {
        bankClientService = new BankClientService();
    }
}
