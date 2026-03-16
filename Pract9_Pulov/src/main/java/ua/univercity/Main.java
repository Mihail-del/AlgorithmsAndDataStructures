package ua.univercity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===");

        System.out.println("| Static Nested class");
        Car myCar = new Car("Audi R8");

        Car.Engine customEngine = new Car.Engine(500);
        System.out.println("Custom engine power: " + customEngine.getHorsepower() + " h.p.");

        Car.Engine defaultEngine = myCar.spec();
        System.out.println("Base engine power: " + defaultEngine.getHorsepower() + " h.p.");


        System.out.println("\n| Inner class");
        Library myLibrary = new Library("Nowi Swiat biblioteka");
        Library.Book myBook = myLibrary.new Book("Piano tutor", "Frederik Chopin");

        System.out.println(myBook.bookLabel());

        //! === TASK TWO ===
        System.out.println("\n\n=== TASK TWO ===");

        LocalAnonymous demo = new LocalAnonymous();

        System.out.println("| Local Class");
        String ticket1 = demo.buildTicketId("VIP");
        String ticket2 = demo.buildTicketId("REGULAR");
        System.out.println("Ticket 1: " + ticket1);
        System.out.println("Ticket 2: " + ticket2);

        System.out.println("\n| Anonymous Class");
        Runnable task = demo.runOnce();
        task.run();

        //! === TASK THREE ===
        System.out.println("\n\n=== TASK THREE ===");

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(2, 100500));
        tickets.add(new Ticket(1, 100200));
        tickets.add(new Ticket(1, 100100));
        tickets.add(new Ticket(3, 100000));

        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
        System.out.println("| Anonymous class: " + tickets);

        tickets.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));
        System.out.println("| Lambda: " + tickets);

        tickets.sort(Comparator.comparing(Ticket::getPriority));
        System.out.println("| Method Reference: " + tickets);

        System.out.println("\n=== Chosing strategy ===");

        // Renew not sorted list
        tickets.clear();
        tickets.add(new Ticket(2, 100500));
        tickets.add(new Ticket(1, 100200));
        tickets.add(new Ticket(1, 100100));
        tickets.add(new Ticket(3, 100000));

        sortAndPrint(tickets, "createdAt");
        sortAndPrint(tickets, "priorityThenCreatedAt");
    }

    public static void sortAndPrint(List<Ticket> list, String strategy) {
        switch (strategy) {
            case "priority":
                list.sort(TicketComparators.BY_PRIORITY);
                break;
            case "createdAt":
                list.sort(TicketComparators.BY_CREATED_AT);
                break;
            case "priorityThenCreatedAt":
                list.sort(TicketComparators.BY_PRIORITY_THEN_CREATED_AT);
                break;
            default:
                System.out.println("Unknown strategy: " + strategy);
                return;
        }
        System.out.println("Strategy '" + strategy + "': " + list);

        //! === TASK FOUR ===
        System.out.println("\n\n=== TASK FOUR ===");

        System.out.println("| @Data (UserDto)");
        UserDto user = new UserDto();
        user.setId("U123");
        user.setEmail("student@mail.com");
        System.out.println("User: " + user);

        System.out.println("\n| @Value (Price)");
        Price price = new Price(99.99, "PLN");
        System.out.println("Price: " + price.getAmount() + " " + price.getCurrency());
        System.out.println("Price toString: " + price);

        System.out.println("\n| @Builder (CheckoutRequest) ===");
        CheckoutRequest request = CheckoutRequest.builder()
                .user(user)
                .price(price)
                .deliveryAddress("Warsaw, ul. Zlota, 2")
                .build();
        System.out.println("Checkout Request created: " + request);
    }
}