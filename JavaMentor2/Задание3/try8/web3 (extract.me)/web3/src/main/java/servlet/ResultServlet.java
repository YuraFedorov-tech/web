package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message",req.getParameter("message"));
        int status=Integer.parseInt(req.getParameter("status"));
        resp.setStatus(status);
        req.getServletContext().getRequestDispatcher("/jsp/resultPage.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }
}
