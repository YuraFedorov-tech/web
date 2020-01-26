package servlet;

import model.BankClient;
import service.BankClientService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class MoneyTransactionServlet extends HttpServlet {

    private BankClientService bankClientService ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator.getInstance().getPage("moneyTransactionPage.html", new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderName=req.getParameter("senderName");
        String senderPass=req.getParameter("senderPass");
        String nameTo=req.getParameter("nameTo");
        String stringCount=req.getParameter("count");
       String message="The transaction was successful";
        int status = 200;
        if(isAllNotNull(senderName,senderPass,nameTo,stringCount)){
            Long count=Long.parseLong(stringCount);
            if(bankClientService.sendMoneyToClient(new BankClient(senderName,senderPass),nameTo,count )){

            }else{
                status=400;
                message="transaction rejected";
            }
        }
        resp.sendRedirect(req.getServletContext()+"/result?message="+message+"&status="+status);
    }

    private boolean isAllNotNull(String senderName, String senderPass, String nameTo, String stringCount) {
        boolean q=!senderName.isEmpty()&& !senderPass.isEmpty()&& !nameTo.isEmpty()&& !stringCount.isEmpty();
        return q;
    }

    @Override
    public void init() throws ServletException {
        bankClientService=BankClientService.getInstance();
    }

}
