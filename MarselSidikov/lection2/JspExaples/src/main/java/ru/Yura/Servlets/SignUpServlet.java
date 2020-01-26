package ru.Yura.Servlets;

import ru.Yura.models.User;
import ru.Yura.repositories.UsersRepositoriesInMemory;
import ru.Yura.repositories.UsersRepository;

import javax.servlet.RequestDispatcher;
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
    private UsersRepository usersRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        req.setAttribute("UsersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        //    RequestDispatcher dispatcher=req.getServletContext().getRequestDispatcher("/jsp/signUpOld.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
        usersRepository.save(new User(name, password, birthDay));
doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        usersRepository = new UsersRepositoriesInMemory();
    }
}
