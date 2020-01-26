package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    UserService userService = UserService.getInstance();
    private Map<Long, User> usersInBase = Collections.synchronizedMap(new HashMap<>());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("222");
        UserService userService1=userService;
        resp.getWriter().write("login method get");
        System.out.println("333");

        System.out.println("4444");
        System.out.println(usersInBase);
        System.out.println("55555");
        req.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    resp.getWriter().write("login vethod put");
        String id=req.getParameter("id");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        userService.addUser(new User(email,password));
        userService.displayDataBase();
        usersInBase=userService.getDateBase();
       // List<User> users=(ArrayList)usersInBase.values();

        req.setAttribute("userInBase", usersInBase);

        doGet(req, resp);


    }
}
