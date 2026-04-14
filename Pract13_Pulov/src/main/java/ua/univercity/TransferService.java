package ua.univercity;

class TransferService {

    public static void transfer(Account from, Account to, int amount) {
        Account firstLock = from.getId() < to.getId() ? from : to;
        Account secondLock = from.getId() < to.getId() ? to : from;

        if (from.getId() == to.getId()) return;

        synchronized (firstLock) {

            try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            synchronized (secondLock) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                } else {
                    System.out.println("Not enough funds in account " + from.getId());
                }
            }
        }
    }
}