package ua.univercity;

public class SynchronizedInventory implements Inventory {
    private int items;

    public SynchronizedInventory(int initialItems) {
        this.items = initialItems;
    }

    @Override
    public synchronized void reserve(int amount) {
        if (items >= amount) {
            items -= amount;
        }
    }

    @Override
    public synchronized int available() {
        return items;
    }
}
