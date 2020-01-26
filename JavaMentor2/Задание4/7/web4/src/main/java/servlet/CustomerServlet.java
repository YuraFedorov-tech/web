package servlet;

import com.google.gson.Gson;
import model.Car;
import model.DailyReport;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static CarService carService;
    private static DailyReportService dailyReportService;
    private static int t;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json = gson.toJson(carService.getAllCars());
        System.out.println("CustomerServlet:     doget"+json);
        int status = 400;
        if (!json.isEmpty()) {
            resp.getWriter().write(json);
            status = 200;
        }
        resp.setStatus(status);
    }

    //покупка автомобиля
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        int status = 403;
        Car car = new Car(brand, model, licensePlate);
        System.out.println(car);
        if (carService.buy(car)) {
            dailyReportService.addOneBuying(car.getPrice());
            status = 200;
        }
        System.out.println("status  customer=" + status);
    }
    @Override
    public void init() throws ServletException {
        dailyReportService = DailyReportService.getInstance();
        carService = CarService.getInstance();
    }
}
