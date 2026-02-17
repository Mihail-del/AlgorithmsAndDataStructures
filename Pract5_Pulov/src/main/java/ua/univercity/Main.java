package ua.univercity;

public class Main {
    public static void main(String[] args) {
        //! ===== TASK ONE =====
        System.out.println("===== TASK ONE =====");

        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod card = new CardPayment();
        PaymentMethod paypal = new PayPalPayment();

        processor.process(card, 100);
        processor.process(paypal, 500);

        System.out.println("\n> Pay with fee (Default method)");
        card.payWithFee(200, 25);

        //! ===== TASK TWO =====
        System.out.println("===== TASK TWO =====");

        System.out.println("User requests Daily Report:");
        ReportGenerator myReport = new DailyReport();
        myReport.generate();

        System.out.println("User requests Financial Report:");
        new FinancialReport().generate();

        //! ===== TASK THREE =====
        System.out.println("===== TASK THREE =====");

        MultiNotifier notifier = new MultiNotifier();
        notifier.send("Важливе повідомлення!");
    }
}
