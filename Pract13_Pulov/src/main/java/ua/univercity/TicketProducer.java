package ua.univercity;

class TicketProducer implements Runnable {
    private final TicketQueue queue;
    private final int numConsumers;
    private final int ticketsToGenerate;

    public TicketProducer(TicketQueue queue, int numConsumers, int ticketsToGenerate) {
        this.queue = queue;
        this.numConsumers = numConsumers;
        this.ticketsToGenerate = ticketsToGenerate;
    }

    @Override
    public void run() {
        String[] topics = {"Card block", "Set limit", "Cashback question", "Transfer error"};;
        String[] customers = {"Oleg", "Maria", "Ivan", "Anna", "Dmitro"};

        try {
            for (int i = 1; i <= ticketsToGenerate; i++) {
                String topic = topics[(int) (Math.random() * topics.length)];
                String customer = customers[(int) (Math.random() * customers.length)];

                queue.put(new SupportTicket(i, customer, topic));
            }

            for (int i = 0; i < numConsumers; i++) {
                queue.put(TicketQueue.POISON_PILL);
            }
            System.out.println("Producer finished generation and sent " + numConsumers + " POISON_PILLs");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
