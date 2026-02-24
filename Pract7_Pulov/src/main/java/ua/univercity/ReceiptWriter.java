package ua.univercity;

import java.io.IOException;

public class ReceiptWriter implements AutoCloseable {

    public void write(Order order) throws IOException {
        System.out.println("Writing receipt for order #" + order.id());
    }

    @Override
    public void close() {
        System.out.println("ReceiptWriter is closed");
    }
}
