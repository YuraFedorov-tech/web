package ru.Yura.Servlets;

import ru.Yura.models.User;
import ru.Yura.reposytory.UserRepository;
import ru.Yura.reposytory.UserRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userRepository.findAll();
        System.out.println(users);
        req.setAttribute("usersFromServer", users);
        System.out.println(users);
        req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        userRepository.save(new User(name, password, LocalDate.parse(birthday)));
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryInMemory();
    }
}
