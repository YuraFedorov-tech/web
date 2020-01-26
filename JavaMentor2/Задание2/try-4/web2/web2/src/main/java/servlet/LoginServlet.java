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
        req.getServletContext().getRequestDispatcher("/jsp/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("email").equals("") && !req.getParameter("password").equals("")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(email, password);
            if (userService.authUser(user)) {
                resp.setStatus(200);
            } else {
                resp.setStatus(400);
            }
        } else {
            resp.setStatus(400);
        }

    }

    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        System.out.println(userService + "init LoginServlet");
    }
}
