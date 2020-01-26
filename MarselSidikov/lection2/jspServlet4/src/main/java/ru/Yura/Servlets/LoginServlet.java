package ru.Yura.Servlets;

import ru.Yura.reposytory.UserRepository;
import ru.Yura.reposytory.UserRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if(userRepository.isExist(name, password)){
            HttpSession session=req.getSession(false);
            session.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }

    @Override
    public void init() throws ServletException {
        this.userRepository=new UserRepositoryInMemory();
    }
}
