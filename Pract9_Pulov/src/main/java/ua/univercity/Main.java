package ua.univercity;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        /*
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
        */

        //! === TASK TWO ===
        LocalAnonymous demo = new LocalAnonymous();

        System.out.println("| Local Class");
        String ticket1 = demo.buildTicketId("VIP");
        String ticket2 = demo.buildTicketId("REGULAR");
        System.out.println("Ticket 1: " + ticket1);
        System.out.println("Ticket 2: " + ticket2);

        System.out.println("\n| Anonymous Class");
        Runnable task = demo.runOnce();
        task.run();
    }
}