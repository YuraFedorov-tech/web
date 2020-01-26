package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mult")


public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String ans = request.getParameter("value");

        System.out.println(ans);
        int an = 0;
        int status = 200;
        System.out.println(" value=" + ans);
        try {
            an = Integer.parseInt(ans) * 2;
            System.out.println(" status=200");

        } catch (Exception y) {
            System.out.println("Exeption");
            status = 400;
            System.out.println(" status=400");
        }
        response.getWriter().write(Integer.toString(an));
        response.setStatus(status);
    }
}

