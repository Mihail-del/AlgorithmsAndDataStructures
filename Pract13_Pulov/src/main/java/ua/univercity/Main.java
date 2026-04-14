package ua.univercity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===\n");

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



        //! === TASK TWO ===
        System.out.println("\n\n=== TASK TWO ===\n");

        Inventory unsafe = new UnsafeInventory(100);
        runReservationExperiment(unsafe);
        System.out.println("UnsafeInventory balance: " + unsafe.available());

        Inventory safe = new SynchronizedInventory(100);
        runReservationExperiment(safe);
        System.out.println("SynchronizedInventory balance: " + safe.available());

        runStressTest(500);
    }

    private static void runReservationExperiment(Inventory inventory) throws InterruptedException {
        Thread thread1 = new Thread(() -> inventory.reserve(60));
        Thread thread2 = new Thread(() -> inventory.reserve(60));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void runStressTest(int iterations) throws InterruptedException {
        int violationsCount = 0;

        for (int i = 0; i < iterations; i++) {
            Inventory unsafe = new UnsafeInventory(100);
            runReservationExperiment(unsafe);

            if (unsafe.available() < 0) {
                violationsCount++;
            }
        }

        System.out.println("Cycled " + iterations + " times");
        System.out.println("Quantity of errors (available < 0): " + violationsCount);



        //! === TASK THREE ===
        System.out.println("\n\n=== TASK THREE ===\n");

        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                TransferService.transfer(acc1, acc2, 10);
            }
            System.out.println("Thread One finished");
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                TransferService.transfer(acc2, acc1, 10);
            }
            System.out.println("Thread Two finished");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final balance of Account 1: " + acc1.getBalance());
        System.out.println("Final balance of Account 2: " + acc2.getBalance());
    }
}
