package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CircleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s="<html>"+"<body>"+"HI NI000000000000000000000000GER"+"</br>"+"</body>"+"</html>";
        resp.getWriter().write(s);
        resp.getWriter().write(s);
        resp.getWriter().write(s);
    }
}
