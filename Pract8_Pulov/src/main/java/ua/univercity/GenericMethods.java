package ua.univercity;

import java.util.List;

public class GenericMethods {

    public static <T> T firstOrNull(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static double sum(List<? extends Number> list) {
        double total = 0.0;
        if (list != null) {
            for (Number number : list) {
                total += number.doubleValue();
            }
        }
        return total;
    }

    public static void addDefaultIds(List<? super Integer> list) {
        if (list != null) {
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println("Added default ID: " + list);
        }
    }
}
