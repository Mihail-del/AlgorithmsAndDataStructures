package ua.univercity;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===");
        ZoneId kyivZone = ZoneId.of("Europe/Kiev");

        // Init events
        Event e1 = new Event("First Event", LocalDateTime.of(2026, 3, 25, 10, 0), 60, kyivZone, "Track A");
        Event e2 = new Event("Second Event", LocalDateTime.of(2026, 3, 25, 11, 30), 45, kyivZone, "Track B");

        // Test methods
        System.out.println(e1.label() + " ends at: " + e1.end());
        System.out.println(e2.label() + " ends at: " + e2.end());



    }
}