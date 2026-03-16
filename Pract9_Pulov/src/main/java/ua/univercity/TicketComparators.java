package ua.univercity;

import java.util.Comparator;

public class TicketComparators {

    public static class PriorityComparator implements Comparator<Ticket> {
        @Override
        public int compare(Ticket t1, Ticket t2) {
            return Integer.compare(t1.getPriority(), t2.getPriority());
        }
    }

    public static final Comparator<Ticket> BY_PRIORITY = Comparator.comparing(Ticket::getPriority);
    public static final Comparator<Ticket> BY_CREATED_AT = Comparator.comparing(Ticket::getCreatedAt);

    public static final Comparator<Ticket> BY_PRIORITY_THEN_CREATED_AT = BY_PRIORITY.thenComparing(BY_CREATED_AT);
}
