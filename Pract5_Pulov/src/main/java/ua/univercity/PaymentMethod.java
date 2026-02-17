package ua.univercity;

interface PaymentMethod {
    String name();
    void pay(int amount);

    default void payWithFee(int amount, int fee) {
        System.out.println("Added fee: " + fee);
        pay(amount + fee);
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public String name() {
        return "Visa/MasterCard";
    }

    @Override
    public void pay(int amount) {
        System.out.println("Pay with card: pay " + amount + " usd");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public String name() {
        return "PayPal";
    }

    @Override
    public void pay(int amount) {
        System.out.println("Pay with PayPal: transfer " + amount + " usd");
    }
}

class PaymentProcessor {
    public void process(PaymentMethod method, int amount) {
        System.out.println("\nProcessing payment with " + method.name());
        method.pay(amount);
    }
}
