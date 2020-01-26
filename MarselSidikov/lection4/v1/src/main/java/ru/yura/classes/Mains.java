package ru.yura.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/*
 *@Data 12.01.2020
 *@autor Fedorov Yuri
 *@project reflectiondemo
 *   ru.yura.classes.Human
 *   ru.yura.classes.Table
 */
public class Mains {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();
        Class aClass = Class.forName(className);
        Field fields[] = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getType() + "  " + field.getName());
        }
        Object object = aClass.newInstance();
        System.out.println(object);
        Class types[] = new Class[fields.length];
        for (int i = 0; i < fields.length; i++) {
            types[i] = fields[i].getType();
        }
        Constructor constructor = aClass.getDeclaredConstructor(types);
        for (Class parametrConstructor : constructor.getParameterTypes()) {
            System.out.print(parametrConstructor.getName() + "   ");

        }
        Integer intValue = null;
        String stringValue = null;
        for (int i = 0; i < types.length; i++) {

            if (types[i].getName().equals("int")) {
                intValue = scanner.nextInt();
            } else if (types[i].getName().equals("java.lang.String")) {
                stringValue = scanner.next().trim();
            }
        }
        Object[] arguments = {intValue, stringValue};
        Object object2 = constructor.newInstance(arguments);
        System.out.println(object2);
    }

}
