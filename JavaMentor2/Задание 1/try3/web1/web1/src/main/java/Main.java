import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


public class Main {
    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainServlet), "/mult");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
