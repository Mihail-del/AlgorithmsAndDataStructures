package ua.univercity;

import java.util.concurrent.ConcurrentHashMap;

class TicketConsumer implements Runnable {
    private final TicketQueue queue;
    private final ConcurrentHashMap<String, Integer> stats;
    private final String name;

    public TicketConsumer(TicketQueue queue, ConcurrentHashMap<String, Integer> stats, String name) {
        this.queue = queue;
        this.stats = stats;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket ticket = queue.take();

                if (ticket == TicketQueue.POISON_PILL) {
                    System.out.println(name + " got POISON_PILL and finished work");
                    break;
                }

                Thread.sleep(10);

                stats.merge(ticket.topic(), 1, Integer::sum);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(name + " was interrupted");
        }
    }
}
