package ua.univercity;

public class Main {
    public static void main(String[] args) {
        //!     === TASK ONE ===
// /*
        try {
            Order valid = new Order(1213310, "Irzhek@mail.pl", 3);
            System.out.println("Success order: " + valid);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Order invalidId = new Order(-1, "Irzhek@mail.pl", 3);
            System.out.println("Success order: " + invalidId);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Order invalidMail = new Order(43242, "IrzhekNoMail.pl", 3);
            System.out.println("Success order: " + invalidMail);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Order invalidCents = new Order(43242, "Irzhek@mail.pl", -2);
            System.out.println("Success order: " + invalidCents);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
//        /*
    }
}