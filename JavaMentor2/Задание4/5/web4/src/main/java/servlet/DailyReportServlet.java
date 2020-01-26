package servlet;

import DAO.CarDao;
import com.google.gson.Gson;
import model.Car;
import org.hibernate.Session;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/report")
public class DailyReportServlet extends HttpServlet {
    private static CarService carService;
    private static DailyReportService dailyReportService;
private static int t;
    @Override
    public void init() throws ServletException {
        System.out.println("DailyReportServlet");
        carService=CarService.getInstance();
        dailyReportService= DailyReportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  doDelete(req,resp); //delete
       if(t==3){
           int d=0;
       }

        t++;

        Gson gson = new Gson();
        String json="";

        if (req.getPathInfo().contains("all")) {

            json = gson.toJson(dailyReportService.getAllDailyReports());
           // DailyReportService.getInstance().getAllDailyReports();
        } else if (req.getPathInfo().contains("last")) {
            DailyReportService.getInstance().getLastReport();
            json = gson.toJson(dailyReportService.getLastReport());
        }else
            return;
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
        System.out.println(json);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dailyReportService.deleteAllBase();

    }
}
