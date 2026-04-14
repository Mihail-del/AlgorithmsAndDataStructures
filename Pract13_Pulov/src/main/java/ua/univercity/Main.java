package ua.univercity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        System.out.println("=== TASK ONE ===");

        List<Order> orders = List.of(
                new Order(1L, 1500),
                new Order(2L, 450),
                new Order(3L, 3200),
                new Order(4L, 900)
        );

        long[] sumResult = new long[1];
        int[] maxResult = new int[1];

        Runnable sumTask = () -> {
            long sum = 0;
            for (Order o : orders) {
                sum += o.totalCents();
            }
            sumResult[0] = sum;
        };

        Runnable maxTask = () -> {
            int max = 0;
            for (Order o : orders) {
                if (o.totalCents() > max) {
                    max = o.totalCents();
                }
            }
            maxResult[0] = max;
        };

        TaskRunner.runAndWait(List.of(sumTask, maxTask));

        System.out.println("Total sum (cents): " + sumResult[0]);
        System.out.println("Max order (cents): " + maxResult[0]);
    }
}
