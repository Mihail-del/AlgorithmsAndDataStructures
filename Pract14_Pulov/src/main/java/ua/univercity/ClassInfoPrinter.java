package ua.univercity;

import java.util.Arrays;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ClassInfoPrinter {
    public static void print(Class<?> clazz) {
        System.out.println("| Reflection Inspector for: " + clazz.getSimpleName());

        System.out.println("Name: " + clazz.getName());

        Class<?> superClass = clazz.getSuperclass();
        System.out.println("Superclass: " + (superClass != null ? superClass.getName() : "None"));

        System.out.println("Interfaces: " + Arrays.toString(clazz.getInterfaces()));

        System.out.println("\nDeclared Fields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(" - " + field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println("\nDeclared Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method.getReturnType().getSimpleName() + " " + method.getName() + "()");
        }
    }
}