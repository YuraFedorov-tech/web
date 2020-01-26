package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/mult")


public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        String ans=request.getParameter("value");
        System.out.println(ans);
        int an=0;
        int status=200;
        System.out.println(" value=" + ans);
      try{
          an = Integer.parseInt(ans) * 2;
          System.out.println(" status=200");

      }catch (Exception y){
          System.out.println("Exeption");
          status=400;
          System.out.println(" status=400");
        }
        pageVariables.put("message", Integer.toString(an));
        response.getWriter().write(Integer.toString(an));
    //    response.getWriter().println(new PageGenerator().getPage("page.html", pageVariables));
    //   response.setContentType("text/html;charset=utf-8");
       response.setStatus(status);
    }

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }*/

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        return pageVariables;
    }
}



// response.getWriter().println(new PageGenerator().getPage("page.html", pageVariables));