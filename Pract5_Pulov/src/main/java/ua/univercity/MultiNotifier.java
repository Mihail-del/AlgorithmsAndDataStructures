package ua.univercity;

interface SmsNotifier {
    default void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

interface EmailNotifier {
    default void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class MultiNotifier implements SmsNotifier, EmailNotifier {
    @Override
    public void send(String message) {
        System.out.println("> Start of multi notifying");

        SmsNotifier.super.send(message);
        EmailNotifier.super.send(message);

        System.out.println("> End of multi notifying");
    }
}
