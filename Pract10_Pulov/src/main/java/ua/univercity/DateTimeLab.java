package ua.univercity;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {

    public static Instant toInstant(Event e) {
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    public static long minutesBetween(Event a, Event b) {
        Instant startA = toInstant(a);
        Instant startB = toInstant(b);


        return Math.abs(Duration.between(startA, startB).toMinutes());
    }

    public static ZonedDateTime startInZone(Event e, String targetZone) {
        return e.getStart()
                .atZone(e.getZone())
                .withZoneSameInstant(ZoneId.of(targetZone));
    }
}