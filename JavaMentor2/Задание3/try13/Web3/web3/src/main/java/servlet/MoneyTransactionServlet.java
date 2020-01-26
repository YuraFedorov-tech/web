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
        resp.getWriter().println(PageGenerator.getInstance().getPage("moneyTransactionPage.html", new HashMap<>()));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String senderName=req.getParameter("senderName");
        String senderPass=req.getParameter("senderPass");
        String nameTo=req.getParameter("nameTo");
        String stringCount=req.getParameter("count");
       String message="The transaction was successful";
        int status = 200;
        System.out.println(senderName+" "+ senderPass +" "+ nameTo+ " "+stringCount);
            Long count=Long.parseLong(stringCount);
            if(bankClientService.sendMoneyToClient(new BankClient(senderName,senderPass),nameTo,count )){

            }else{
                status=400;
                message="transaction rejected";
            }

        resp.sendRedirect(req.getServletContext()+"/result?message="+message+"&status="+status);
        resp.setStatus(HttpServletResponse.SC_OK);
    }



    @Override
    public void init() throws ServletException {
         bankClientService =new  BankClientService();
    }

}
