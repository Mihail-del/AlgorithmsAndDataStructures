package ua.univercity;

public class LocalAnonymous {
    public String buildTicketId(String base) {
        String prefix = "TICKET_";

        class IdBuilder {
            public String build() {
                return prefix + base + "-" + System.currentTimeMillis();
            }
        }

        IdBuilder builder = new IdBuilder();
        return builder.build();
    }

    public Runnable runOnce() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class runed");
            }
        };
    }
}
