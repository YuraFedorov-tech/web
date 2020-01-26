package servlet;

import com.google.gson.Gson;
import model.Car;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static CarService carService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json = gson.toJson(carService.getAllCars());
        System.out.println(json);

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
     //   String price = req.getParameter("price");

        brand = "1";
        model = "1";
        licensePlate = "1";
    //    price = "1";
        int status = 403;
        if(carService.buy(new Car(brand,model,licensePlate))){
            status=200;
        }
        System.out.println("status  customer="+status);
    }

    @Override
    public void init() throws ServletException {
        carService=CarService.getInstance();
    }
}
