package ua.univercity;

import java.io.IOException;

public class ReceiptService {
    public void generate(Order order) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.write(order);
        } catch (IOException e) {
            throw new ReceiptGenerationException("Couldn't create a receipt for order " + order.id(), e);
        }
    }
}
