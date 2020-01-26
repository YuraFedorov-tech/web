package DAO;

import model.Car;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CarDao {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    public List<Car> getAllCars() {
        String hql = "FROM Car";
        Query query = session.createQuery(hql);
        List<Car> cars = query.list();
        return cars;
    }


    public boolean addCar(Car car) {
        List<Car> cars = getAllCarsWhereModelIs(car.getBrand());
        if (cars.size() >= 10)
            return false;
        if (isHaveSuchCar(car, cars))
            return false;
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        return true;
    }

    private boolean isHaveSuchCar(Car car, List<Car> cars) {
        for (Car carInBase : cars)
            if (carInBase.getModel().equals(car.getModel()) && carInBase.getLicensePlate().equals(car.getLicensePlate())) {
                return true;
            }
        return false;
    }

    private List<Car> getAllCarsWhereModelIs(String brand) {
        String hql = "FROM Car WHERE brand='" + brand + "'";
        Query query = session.createQuery(hql);
        List<Car> cars = (List<Car>)query.list();
        return cars;
    }

    public boolean buyCar(Car car) {
        List<Car> cars = getAllCarsWhereModelIs(car.getBrand());
        int i = cars.indexOf(car);
        if (i == -1)
            return false;
        Car carInBase = cars.get(i);
        long price = carInBase.getPrice();
        car.setPrice(price);
        session.beginTransaction();
        session.delete(carInBase);
        session.getTransaction().commit();
        return true;
    }
}
