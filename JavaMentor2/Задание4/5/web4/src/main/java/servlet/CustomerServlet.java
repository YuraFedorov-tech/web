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
        System.out.println(json);
        int status = 400;
        if (!json.isEmpty()) {
            //     resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(json);
            status = 200;
        }
        resp.setStatus(status);


        //    doPost(req, resp);//delete
    }


    //покупка автомобиля
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        t++;
        System.out.println("tBuy="+t);
        if(t==12){
            int y=4;
        }
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        //   String price = req.getParameter("price");

//        brand = "1";
//        model = "1";
//        licensePlate = "1";
        //    price = "1";
        int status = 403;
        if (model.equals("taTouo")) {
            System.out.println("taTouo");
        }
        Car car = new Car(brand, model, licensePlate);
        System.out.println(car);
        //   Car car=new Car("BMV","7","H243MP");
//        dailyReportService.getAllDailyReports();
//        for(int i=0;i<5;i++) {
        if (carService.buy(car)) {
            dailyReportService.addOneBuying(car.getPrice());
            status = 200;
        }
        System.out.println("status  customer=" + status);
    }
//    }

    @Override
    public void init() throws ServletException {
        dailyReportService = DailyReportService.getInstance();
        carService = CarService.getInstance();
    }
}
