package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

       Map<String, String[]> myMap=request.getParameterMap();
        Set<String> listKey=myMap.keySet();
        Iterator y=listKey.iterator();
        while(y.hasNext()){
            prin(myMap,(String) y.next());
        }

        Map<String, Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("message", "");

        response.getWriter().println(new PageGenerator().getPage("page.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    String val=request.getParameter("value");
    int value=Integer.parseInt(val);
        value*=2;
        String s2=Integer.toString(value);
        String s="<html>"+"<body>"+s2+"</br>"+"</body>"+"</html>";
        response.getWriter().write(s);



    }

    private void prin(Map<String,String[]> myMap, String next) {
        System.out.print(next+" ");
        String s[]=myMap.get(next);
        for(String s1:s){
            System.out.println(s1);
        }
        System.out.println("/////////////////////");
    }


    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        return pageVariables;
    }


}
