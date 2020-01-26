
/*
 *
 *@Data 23.01.2020
 *@autor Fedorov Yuri
 *@project web4
 *
 */

import com.google.gson.Gson;
import model.Car;

public class GsonDemo {
    public static void main(String[] args) {
        Car car=new Car();
        car.setId(2L);
        car.setBrand("BMV");
        car.setLicensePlate("E4546TY");
        car.setModel("picap");

        Gson gson=new Gson();
        String toGson=gson.toJson(car);
        System.out.println(toGson);


        Car car2=gson.fromJson(toGson,Car.class);
        System.out.println(car2);
    }
}
