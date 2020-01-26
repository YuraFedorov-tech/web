package ru.Yura.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@WebServlet("/temp")
public class MainServlet extends HttpServlet {
    int j = 0;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("temp");
        synchronized(this) {
            for (int i = 0; i < 200_000; i++) {
                j++;
            }
        }
        System.out.println(j);
    }

}
