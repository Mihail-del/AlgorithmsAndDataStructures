package ua.univercity;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

class TicketQueue {
    public static final SupportTicket POISON_PILL = new SupportTicket(-1, "SYSTEM", "SHUTDOWN");

    private final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(100);

    public void put(SupportTicket ticket) throws InterruptedException {
        queue.put(ticket);
    }

    public SupportTicket take() throws InterruptedException {
        return queue.take();
    }
}
