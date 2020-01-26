package service;

import DAO.CarDao;
import com.google.gson.Gson;
import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.DBHelper;

import java.util.List;

public class CarService {

    private static CarService carService;
    private SessionFactory sessionFactory;

    private CarService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService(DBHelper.getSessionFactory());
        }
        return carService;
    }


    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        List<Car> cars=new CarDao(session).getAllCars();
        session.close();
        return cars;
    }

    public boolean addCar(Car car) {
        Session session = sessionFactory.openSession();
        if(new CarDao(session).addCar(car)){
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    public boolean buy(Car car) {
        Session session = sessionFactory.openSession();
        if(new CarDao(session).buyCar(car)){
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}
