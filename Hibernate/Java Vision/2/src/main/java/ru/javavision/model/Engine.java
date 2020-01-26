package ru.javavision.model;

import lombok.*;

import java.io.Serializable;

/**
 * Author : Pavel Ravvich.
 * Created : 26/11/2017.
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    private String model;
//    public Engine(){

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }
//
//    }
//    public Engine(String engine_model_03, int i) {
//        model=engine_model_03;
//        power=i;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public void setPower(int power) {
//        this.power = power;
//    }

    private int power;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
