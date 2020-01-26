
import exception.DBException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.BankClientService;
import model.BankClient;
import servlet.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiServlet apiServlet = new ApiServlet();
        ResultServlet resultServlet = new ResultServlet();
        MoneyTransactionServlet moneyTransactionServlet = new MoneyTransactionServlet();
        RegistrationServlet registrationServlet = new RegistrationServlet();
        PrinterServlet printerServlet = new PrinterServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(apiServlet), "/api/*");
        context.addServlet(new ServletHolder(resultServlet), "/result");
        context.addServlet(new ServletHolder(moneyTransactionServlet), "/transaction");
        context.addServlet(new ServletHolder(registrationServlet), "/registration");
        context.addServlet(new ServletHolder(printerServlet), "/print");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
        //SET GLOBAL time_zone = '+2:00';
        //?serverTimezone=Europe/Moscow
    }
}
