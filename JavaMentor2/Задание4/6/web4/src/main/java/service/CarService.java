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
     //       carService.incudeCars();
        }
        return carService;
    }


    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        List<Car> cars=new CarDao(session).getAllCars();

        session.close();
        return cars;
    }

    public void incudeCars() {
        Car car2=new Car("Mers","3","H243MP",100L);
        Car car3=new Car("Gizul","4","H243MP",10000L);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(int i=0;i<3;i++)
        session.save(new Car("BMV","7","H243MP",100L));
        session.save(car2);
        session.save(car3);
        for(int i=0;i<10;i++)
            session.save(new Car("1","1","1",100L));
        session.getTransaction().commit();
        session.close();
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
