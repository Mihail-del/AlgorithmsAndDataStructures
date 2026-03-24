package ua.univercity;

import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {

    // Sort with anonymous class
    public static void sortAnonymous(List<Event> events) {
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getTitle().compareTo(e2.getTitle());
            }
        });
    }

    // Sort with lambda
    public static void sortLambda(List<Event> events) {
        events.sort((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
    }

    // Sort with method reference
    public static void sortMethodRef(List<Event> events) {
        events.sort(Comparator.comparing(Event::getTitle));
    }
}