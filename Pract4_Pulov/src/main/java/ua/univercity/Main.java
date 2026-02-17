package ua.univercity;

public class Main {
    public static void main(String[] args) {

        // TASK ONE
        Animal[] zoo = {
                new Dog(),
                new Cat(),
                new Dog(),
                new Cat()
        };

        System.out.println("--- Task One ---");

        for (Animal animal : zoo) {
            animal.speak();
        }




        // TASK TWO
        A obj = new B();

        System.out.println("--- Task Two ---");
        obj.process("hi");



        // TASK THREE
        System.out.println("--- Task Three ---");
        Animal a = new Dog();
        Animal b = new Cat();

        if (a instanceof Dog) {
            Dog myDog = (Dog) a;
            myDog.fetchStick();
        } else {
            System.out.println("This is not a dog.");
        }

        if (b instanceof Dog) {
            Dog myDog = (Dog) b;
            myDog.fetchStick();
        } else {
            System.out.println("This is not a dog.");
        }
    }
}