package servlet;

import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DailyReportServlet extends HttpServlet {
    private static CarService carService;

    @Override
    public void init() throws ServletException {
        carService=CarService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo().contains("all")) {
            DailyReportService.getInstance().getAllDailyReports();
        } else if (req.getPathInfo().contains("last")) {
            DailyReportService.getInstance().getLastReport();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        carService.deleteAllBase();
    }
}
