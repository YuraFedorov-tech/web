package ru.yura.classes;

/*
 *@Data 12.01.2020
 *@autor Fedorov Yuri
 *@project reflectiondemo
 *
 */
public class Table {
    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int size;
    public String color;

    public Table() {
    }

    public Table(int size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return size+" "+color;
    }
}
