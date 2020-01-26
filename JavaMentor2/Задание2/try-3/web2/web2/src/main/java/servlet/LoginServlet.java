package servlet;

import model.User;
import service.UserService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //  resp.getWriter().println(new PageGenerator().getPage("authPage.html", new HashMap<>()));

        req.getServletContext().getRequestDispatcher("/jsp/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        if (!req.getParameter("email").equals("") && !req.getParameter("password").equals("")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(email, password);
            if (userService.authUser(user)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        System.out.println(userService + "init LoginServlet");
    }
}
