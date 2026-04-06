package ua.univercity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===\n");

        Path testFile = Path.of("./Pract12_Pulov/src/main/payments.csv");
        Files.writeString(testFile, """
            id,email,status,amountCents
            1,user1@ex.com,PAID,1500
            2,user2@ex.com,NEW,200
            
            3,user3@ex.com,UNKNOWN_STATUS,500
            4,user4@ex.com,FAILED,bad_amount
            5,user5@ex.com,PAID,300
            invalid_format_line
            """);

        PaymentStats stats = PaymentLoader.loadWithStats(testFile);

        System.out.println("=== CSV Parsing Results ===");
        System.out.println("Valid payments loaded: " + stats.payments().size());
        System.out.println("Invalid lines skipped: " + stats.invalidLines());

        System.out.println("\nLoaded data:");
        stats.payments().forEach(System.out::println);

        Files.deleteIfExists(testFile);

        //! === TASK TWO ===

    }
}