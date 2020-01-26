package ru.yura.model;
/*
 *
 *@Data 20.01.2020
 *@autor Fedorov Yuri
 *@project Hibernate example
 *
 */


//@Data

public class Engine {
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    String model;
    int power;
}
