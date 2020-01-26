package ru.yura.classes;

import java.lang.reflect.Field;

/*
 *@Data 12.01.2020
 *@autor Fedorov Yuri
 *@project reflectiondemo
 *
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SomeClass someClass = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someClass.getClass();
        Field someField = someClassAsClass.getField("someFild");
        System.out.println(someField.getType());

        Field[] fields = someClassAsClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getType() + "= " + field.getName() + "");
        }
        System.out.println(someClass.someFild);
        someField.setInt(someClass, 55);
        System.out.println(someClass.someFild);

        Field privateField = someClassAsClass.getDeclaredField("somePrivate");
        System.out.println(privateField.getType() + "  " + privateField.getName());
        privateField.setAccessible(true);
        privateField.set(someClass, "Yura");
        System.out.println(someClass.getSomePrivate());

    }
}
