package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("init RegistrationServletDoGet");
        req.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.print("init RegistrationServletDoPost");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        User user =new User(email,password );
        if(!userService.isExistsThisUser(user)){
            userService.addUser(user);
        }
        doGet(req,resp );
    }


    @Override
    public void init() throws ServletException {
        userService=UserService.getInstance();
        System.out.println(userService+"init RegistrationServlet");
    }

}
