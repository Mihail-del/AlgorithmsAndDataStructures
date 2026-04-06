package ua.univercity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class PaymentLoader {

    public static PaymentStats loadWithStats(Path csv) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;

        try (BufferedReader reader = Files.newBufferedReader(csv)) {

            String line = reader.readLine();
            if (line == null) return new PaymentStats(payments, 0);

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 4) {
                    invalidLines++;
                    continue;
                }

                try {
                    String id = parts[0].trim();
                    String email = parts[1].trim();
                    PaymentStatus status = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
                    int amountCents = Integer.parseInt(parts[3].trim());

                    payments.add(new Payment(id, email, status, amountCents));
                } catch (IllegalArgumentException e) {
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }

        return new PaymentStats(payments, invalidLines);
    }
}
