package ua.univercity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //! ===== TASK ONE =====
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
            System.out.println("Прочитано: " + text);
        }


        //! ===== TASK TWO =====
    }
}