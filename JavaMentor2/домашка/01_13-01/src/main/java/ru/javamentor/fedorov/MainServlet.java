package ru.javamentor.fedorov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *@Data 13.01.2020
 *@autor Fedorov Yuri
 *@project doGet
 *
 */

//      ?fir=5&sec=4&ther=51&forth=41
@WebServlet("/counts")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String first=req.getParameter("fir");
        String second=req.getParameter("sec");
        String third=req.getParameter("ther");
        String forth=req.getParameter("forth");
        System.out.println(getNumber(first)+getNumber(second)+getNumber(third)+getNumber(forth));
    }

    private int getNumber(String str) {
        return Integer.parseInt(str);
    }
}
