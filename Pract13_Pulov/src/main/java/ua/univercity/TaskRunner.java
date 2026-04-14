package ua.univercity;

import java.util.ArrayList;
import java.util.List;

class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = new ArrayList<>();

        for (Runnable task : tasks) {
            Thread t = new Thread(task);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
