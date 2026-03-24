package ua.univercity;

import java.time.LocalDateTime;
import java.time.ZoneId;

// Model for schedule event
public class Event {
    private String title;
    private LocalDateTime start;
    private int durationMinutes;
    private ZoneId zone;
    private String track;

    // Create new Event
    public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    // Return end time
    public LocalDateTime end() {
        return start.plusMinutes(durationMinutes);
    }

    // Return title and track
    public String label() {
        return title + " [" + track + "]";
    }

    // Getters
    public String getTitle() { return title; }
    public LocalDateTime getStart() { return start; }
    public int getDurationMinutes() { return durationMinutes; }
    public ZoneId getZone() { return zone; }
    public String getTrack() { return track; }
}
