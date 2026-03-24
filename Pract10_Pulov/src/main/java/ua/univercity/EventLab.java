package ua.univercity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {

    public static List<Event> pick(List<Event> events, Predicate<Event> condition) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (condition.test(event)) {
                result.add(event);
            }
        }
        return result;
    }

    public static List<String> labels(List<Event> events, Function<Event, String> formatter) {
        List<String> result = new ArrayList<>();
        for (Event event : events) {
            result.add(formatter.apply(event));
        }
        return result;
    }

    public static void notifyAll(List<Event> events, Consumer<Event> action) {
        for (Event event : events) {
            action.accept(event);
        }
    }

    public static Event create(Supplier<Event> factory) {
        return factory.get();
    }

    public static void findConflicts(List<Event> events) {
        System.out.println("\n| Check conflicts");
        boolean found = false;

        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);

                // Convert to Instant
                Instant start1 = e1.getStart().atZone(e1.getZone()).toInstant();
                Instant end1 = e1.end().atZone(e1.getZone()).toInstant();

                Instant start2 = e2.getStart().atZone(e2.getZone()).toInstant();
                Instant end2 = e2.end().atZone(e2.getZone()).toInstant();

                if (start1.isBefore(end2) && end1.isAfter(start2)) {
                    System.out.println("Conflict found: " + e1.label() + " and " + e2.label());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Conflicts not found");
        }
    }
}