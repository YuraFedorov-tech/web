package servlet;

import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewDayServlet extends HttpServlet {
    private static CarService carService;
    private static DailyReportService dailyReportService;

    @Override
    public void init() throws ServletException {
        carService=CarService.getInstance();
        dailyReportService= DailyReportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
