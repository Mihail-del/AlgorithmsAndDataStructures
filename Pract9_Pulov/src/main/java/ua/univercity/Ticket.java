package ua.univercity;

public class Ticket {
    private int priority;
    private long createdAt;

    public Ticket(int priority, long createdAt) {
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public int getPriority() { return priority; }
    public long getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "{p=" + priority + ", time=" + createdAt + "}";
    }
}
