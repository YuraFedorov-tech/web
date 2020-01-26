package servlet;

/*
 *@Data 10.01.2020
 *@autor Fedorov Yuri
 *@project Web3
 *
 */

import exception.DBException;
import model.BankClient;
import service.BankClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/print")
public class PrinterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BankClient> clients = new BankClientService().getAllClient();
        clients=  new BankClientService().getAllClient();
        req.setAttribute("clientInBase", clients);
        req.getServletContext().getRequestDispatcher("/jsp/print.jsp").forward(req,resp);
    }
}
