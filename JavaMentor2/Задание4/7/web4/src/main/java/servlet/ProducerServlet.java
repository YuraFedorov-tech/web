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

    @Override
    public void init() throws ServletException {
        carService = CarService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ProducerServlet: doGet  BAD very bad");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        String price = req.getParameter("price");
        Car car = new Car(brand, model, licensePlate, Long.parseLong(price));
        int status = 403;
        if (carService.addCar(car)) {
            status = 200;
        }
        resp.setStatus(status);
        System.out.println(status + " " + "status");
    }
}
