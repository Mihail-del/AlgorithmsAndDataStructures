package ua.univercity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        //!     === TASK ONE ===
         /*
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
        */

        //!     === TASK TWO ===
         /*
        OrderService service = new OrderService();

        try {
            service.checkout(123, "Gaba@mail.pl");
        } catch (OrderProcessingException e) {
            // Тут ми просто ловимо помилку, щоб програма не впала червоним
            log.info("Caught exception in Main: {}", e.getMessage());
        }

         */

        //!     === TASK THREE ===
         /*
        Order order = new Order(777, "Tymek@mail.pl", 10000);
        ReceiptService receiptService = new ReceiptService();

        try {
            receiptService.generate(order);
        } catch (ReceiptGenerationException e) {
            System.out.println("Error: " + e.getMessage());
        }
         */

        //!     === TASK FOUR ===
        // /*

        // */
    }
}