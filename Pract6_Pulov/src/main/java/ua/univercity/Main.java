package ua.univercity;

public class Main {
    public static void main(String[] args) {
        FakePaymentGateway fakeGateway = new FakePaymentGateway();

        NotificationService emailService = new EmailNotificationService();

        LooseCheckoutProcessor processor = new LooseCheckoutProcessor(fakeGateway, emailService);

        Order order = new Order();
        Money price = Money.ofDollars(100.00);
        OrderItem item = new OrderItem("Java Course", price, 1);
        order.addItem(item);

        PaymentDetails card = new PaymentDetails("4242-4242-4242-4242");
        Email userEmail = new Email("student@ua.university");

        System.out.println("--- Test 1 success ---");
        processor.checkout(order, card, userEmail);

        System.out.println("\n--- Test 2 ---");
        fakeGateway.setFail(true);

        PaymentResult result = processor.checkout(order, card, userEmail);
        System.out.println("Result: " + result);
    }
}