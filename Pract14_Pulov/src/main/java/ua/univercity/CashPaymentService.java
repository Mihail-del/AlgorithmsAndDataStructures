package ua.univercity;

public class CashPaymentService implements PaymentService {
    @Override
    public void pay(int amount) {
        System.out.println("Receiving cash payment of $" + amount + "...");
        System.out.println("Cash payment successful.");
    }
}
