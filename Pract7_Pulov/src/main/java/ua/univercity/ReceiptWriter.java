package ua.univercity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ReceiptWriter implements AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(ReceiptWriter.class);

    public void write(Order order) throws IOException {
        System.out.println("Writing receipt for order #" + order.id());
    }

    @Override
    public void close() {
        log.info("Closing receipt writer");
        System.out.println("ReceiptWriter is closed");
    }
}
