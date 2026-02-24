package ua.univercity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ReceiptService {
    private static final Logger log = LoggerFactory.getLogger(ReceiptService.class);

    public void generate(Order order) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.write(order);
            log.info("Receipt has been generated");
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ReceiptGenerationException("Couldn't create a receipt for order " + order.id(), e);
        }
    }
}
