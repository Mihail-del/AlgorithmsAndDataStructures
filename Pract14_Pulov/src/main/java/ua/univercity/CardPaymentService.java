package ua.univercity;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(int amount) {
        System.out.println("Processing card payment of $" + amount + "...");
        System.out.println("Card payment successful.");
    }
}
