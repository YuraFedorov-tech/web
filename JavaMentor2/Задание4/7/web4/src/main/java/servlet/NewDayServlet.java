package servlet;

import com.google.gson.Gson;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/newday")
public class NewDayServlet extends HttpServlet {
    private static CarService carService;
    private static DailyReportService dailyReportService;
    private static int t;

    @Override
    public void init() throws ServletException {
        System.out.println("NewDayServlet");
        carService = CarService.getInstance();
        dailyReportService = DailyReportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        dailyReportService.addRowForNextDay();
        String json = gson.toJson(dailyReportService.getLastReport());
        int status = 400;
        if (!json.equals(null)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println(json);
            status = 200;
        }
        resp.setStatus(status);
    }
}
