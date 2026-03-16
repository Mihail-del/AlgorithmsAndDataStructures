package ua.univercity;

public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
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
    }
}