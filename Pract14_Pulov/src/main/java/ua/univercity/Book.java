package ua.univercity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class Book implements Cloneable {
    private String title;
    public int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() { return title; }
    private void secretMethod() { System.out.println("Secret"); }
}
