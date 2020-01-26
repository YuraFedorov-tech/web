package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/mult")
public class NumServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("value");
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        //pageVariables.put("value", request.getParameter("value"));

        if (param == null) {
            pageVariables.put("value", 0);

            response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                Integer i = Integer.parseInt(param) * 2;
                pageVariables.put("value", i);
                response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
               // response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }


        //response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));

    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        return pageVariables;
    }
}