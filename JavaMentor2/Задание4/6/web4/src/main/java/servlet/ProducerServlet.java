package servlet;

import model.Car;
import netscape.security.UserTarget;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/producer")
public class ProducerServlet extends HttpServlet {
    private static CarService carService;
private  static int t;
    @Override
    public void init() throws ServletException {
        System.out.println("ProducerServlet");
        carService = CarService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ProducerServlet: doGet  BAD very bad");
       // doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //      System.out.println("ProducerServlet:   doPost");
if(t==19){
    int y=5;
}
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        String price = req.getParameter("price");

//         brand = "5";
//         model = "5";
//         licensePlate = "1";
//         price = "1";

        Car car = new Car(brand, model, licensePlate, Long.parseLong(price));
        System.out.println("ProducerServlet:   doPost:  car="+car+"  t="+t++);
        int status = 403;

        if (carService.addCar(car)) {
            status = 200;
        }
        resp.setStatus(status);
        System.out.println(status + " " + "status");
    }
}
