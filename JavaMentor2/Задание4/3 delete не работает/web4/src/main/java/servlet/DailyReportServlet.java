package servlet;

import DAO.CarDao;
import org.hibernate.Session;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/report")
public class DailyReportServlet extends HttpServlet {
    private static CarService carService;
    private static DailyReportService dailyReportService;

    @Override
    public void init() throws ServletException {
        carService=CarService.getInstance();
        dailyReportService= DailyReportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDelete(req,resp); //delete
        if (req.getPathInfo().contains("all")) {
            DailyReportService.getInstance().getAllDailyReports();
        } else if (req.getPathInfo().contains("last")) {
            DailyReportService.getInstance().getLastReport();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dailyReportService.deleteAllBase();

    }
}
