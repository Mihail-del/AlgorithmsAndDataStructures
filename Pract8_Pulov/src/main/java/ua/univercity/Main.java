package ua.univercity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.univercity.GenericMethods.*;

public class Main {
    public static void main(String[] args) {
        //! ===== TASK ONE =====
        /*
        System.out.println("RAW LIST");

        List rawList = new ArrayList();

        rawList.add("Text line");
        rawList.add(42);

        try {
            for (Object obj : rawList) {
                String text = (String) obj;
                System.out.println("Прочитано: " + text);
            }
        } catch (ClassCastException e) {
            System.out.println("Caught exception in Main");
        }


        System.out.println("\nGERNIC");

        List<String> genericList = new ArrayList<>();
        genericList.add("Line1");
        genericList.add("Line2");

        // genericList.add(42);

        for (String text : genericList) {
            System.out.println("Read: " + text);
        }
        */

        //! ===== TASK TWO =====
        /*
        System.out.println("|  firstOrNull");
        List<String> names = Arrays.asList("One", "Two");
        List<Integer> emptyList = new ArrayList<>();

        System.out.println("First: " + firstOrNull(names));
        System.out.println("Empty: " + firstOrNull(emptyList));


        System.out.println("\n|  sum");
        List<Integer> ints = Arrays.asList(10, 20, 30);
        List<Double> doubles = Arrays.asList(1.5, 2.5);

        System.out.println("Int sum: " + sum(ints));
        System.out.println("Double sum: " + sum(doubles));
        // sum(names);


        System.out.println("\n|  addDefaultIds");
        List<Integer> idList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addDefaultIds(idList);
        addDefaultIds(numberList);
        addDefaultIds(objectList);
        // addDefaultIds(doubles);
        */

        //! ===== TASK THREE =====
        StudentRegistry registry = new StudentRegistry();

        System.out.println("|  DUBLICATES");
        Student s1 = new Student("101", "student@gmail.com", "First");
        Student s2 = new Student("102", "student@gmail.com", "Second");

        registry.addStudent(s1);
        boolean addedDuplicate = registry.addStudent(s2);
        System.out.println("Is added: " + addedDuplicate);


        System.out.println("\n|  DELETING");
        registry.removeById("101");

        boolean addedAfterRemoval = registry.addStudent(s2);
        System.out.println("Is added:  " + addedAfterRemoval);

        registry.printAll();
    }
}