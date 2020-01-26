package ru.yura.classes;

/*
 *@Data 12.01.2020
 *@autor Fedorov Yuri
 *@project reflectiondemo
 *
 */
public class Human {
    public int age;
    public   String name;
    public Human(){
        age=1;
        name="Yuriy";
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age+" "+this.name;
    }
}
