package ua.univercity;

import java.util.Arrays;

public class MemoryTask {

    public void run() {
        int myPrimitive = 100;
        System.out.println("Memory: The value '100' is stored directly in the Stack.");

        StringBuilder sb1 = new StringBuilder("Java");
        System.out.println("Memory: Variable 'sb1' is in Stack. It holds the address pointing to Heap.");

        int[] myArray = {1, 2, 3};
        System.out.println("Memory: Variable 'myArray' is in Stack. The array data {1, 2, 3} is in Heap.");

        StringBuilder sb2 = sb1;
        System.out.println("Memory: 'sb2' is a new variable in Stack, but it copies the address from 'sb1'.");

        sb2.append(" Memory");

        System.out.println("--- Observations ---");
        System.out.println("Primitive: " + myPrimitive);
        System.out.println("Array: " + Arrays.toString(myArray));

        System.out.println("Object 1 (sb1): " + sb1);
        System.out.println("Object 2 (sb2): " + sb2);

        System.out.println("Do sb1 and sb2 reference the same object? " + (sb1 == sb2));
        System.out.println("(We modified sb2, but sb1 changed too because they share the same reference in Heap)");
    }

    public static void main(String[] args) {
        MemoryTask task = new MemoryTask();
        task.run();
}
}