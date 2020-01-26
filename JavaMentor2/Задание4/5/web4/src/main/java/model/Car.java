package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "price")
    private Long price;

    public Car() {

    }

    public Car(String brand, String model, String licensePlate, Long price) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.price = price;
    }

    public Car(String brand, String model, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return brand.equals(car.brand) &&
                model.equals(car.model) &&
                licensePlate.equals(car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, licensePlate);
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", price=" + price +
                '}';
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
