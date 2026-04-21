package ua.univercity;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===\n");

        ClassInfoPrinter.print(Book.class);

        //! === TASK TWO ===
        System.out.println("\n\n=== TASK TWO ===\n");

        System.out.println("| Reflection Service Factory");

        String cardServiceClassName = CardPaymentService.class.getName();
        String cashServiceClassName = CashPaymentService.class.getName();

        PaymentService cardService = (PaymentService) ServiceFactory.create(cardServiceClassName);
        PaymentService cashService = (PaymentService) ServiceFactory.create(cashServiceClassName);

        System.out.println("\n| Testing Card Service");
        cardService.pay(150);

        System.out.println("\n| Testing Cash Service");
        cashService.pay(45);

        //! === TASK THREE ===
        System.out.println("\n\n=== TASK THREE ===\n");

        System.out.println("| Starting StepRunner");

        SetupFlow flow = new SetupFlow();
        StepRunner.run(flow);

        System.out.println("| StepRunner Finished");
    }
}