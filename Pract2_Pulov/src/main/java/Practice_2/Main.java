package Practice_2;

public class Main {

    public static void main(String[] args) {
        // ===== TASK ONE =====
//        BankAccount ba = new BankAccount("toJ3stK0nt0wP1erwsz1mTaske", 100);
//        System.out.println("Balance is: " + ba.getBalance());
//        ba.deposit(110);
//        System.out.println("Balance is: " + ba.getBalance());
//        ba.withdraw(110);
//        System.out.println("Balance is: " + ba.getBalance());
//        ba.withdraw(1100);
//        System.out.println("Balance is: " + ba.getBalance());
//        ba.withdraw(-110);
//        System.out.println("Balance is: " + ba.getBalance());

        // ===== TASK TWO =====
        int[] array1 = new int[]{1, 5, 2, 9, 2};
        System.out.println("Min: "+ArrayStat.findMin(array1));
        System.out.println("Max: "+ArrayStat.findMax(array1));
        System.out.println("Avg: "+ArrayStat.findAvg(array1));

        int[] array2 = new int[]{};
        System.out.println("Min: "+ArrayStat.findMin(array2));
        System.out.println("Max: "+ArrayStat.findMax(array2));
        System.out.println("Avg: "+ArrayStat.findAvg(array2));
    }
}
