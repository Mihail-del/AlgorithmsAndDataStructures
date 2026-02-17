package Practice_2;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        // Check if accountNumber is not negative
        if (accountNumber == null||accountNumber.isEmpty()) {
            throw new IllegalArgumentException("accountNumber cannot be null");
        }
        else {
            this.accountNumber = accountNumber;
        }

        // Check if balance is not negative
        if (initialBalance < 0) {
            this.balance = 0;
            throw new IllegalArgumentException("initial balance cannot be negative");
        }
        else {
            this.balance = initialBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        // Check if amount is not negative
        if (amount < 0) {
            System.out.println("Invalid amount. Must be greater than zero.");
        }
        else {
            this.balance += amount;
            System.out.println("Deposited " + amount + " to balance.");
        }
    }

    public void withdraw(double amount) {
        // Check if amount is not negative
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount. Must be greater than zero.");
        }
        else if (amount > balance) {
            throw new IllegalArgumentException("Not enough balance.");
        }
        else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
