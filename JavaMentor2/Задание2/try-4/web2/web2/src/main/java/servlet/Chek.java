package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/print")
public class Chek extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        req.setAttribute("dataBaseInMemory", users);
        List<User> usersLogin = userService.getAllAuth();
        req.setAttribute("dataBaseInMemoryLogin", usersLogin);
        req.getServletContext().getRequestDispatcher("/jsp/printDataBase.jsp").forward(req, resp);
    }


    @Override
    public void init() throws ServletException {
        userService = UserService.getInstance();
        System.out.println(userService+"init ChekServlet");
    }
}
