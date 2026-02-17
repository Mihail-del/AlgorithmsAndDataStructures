package Practice_1;

public class Main {
    public static void main(String[] args) {
        /* ==== Task One ==== */
        Dog dog = new Dog("Szarik", "Pasterz");
        System.out.println(dog);
        // ==================

        /* ==== Task Two ==== */
        // part 1
        String s1 = new String("hello");
        String s2 = new String("hello");

        // part 2
        System.out.println("\n ---------- \npart 2\n");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));

        //part3
        System.out.println("\n ---------- \npart 3\n");
        for (int i = -128; i <= 127; i++) {
            Integer a = i;
            Integer b = i;
            if (a != b) System.out.println("Different objects found: " + i);
            else System.out.println("a == b: i = " + i);
        }
        Integer x = 128;
        Integer y = 128;
        System.out.println("128 == 128? " + (x == y));

        //part 6
        System.out.println("\n ---------- \npart 6\n");
        Dog dog1 = new Dog("Zuczcka", "Kundel");
        Dog dog2 = new Dog("Zuczcka", "Kundel");

        System.out.println("Are those Polish dogs equals: " + dog1.equals(dog2));
        // ==================

        /* ==== Task Three ==== */
        //part 5
        Animal myAnimal = new Dog("Bobik", "Złoty Retriever");
        feed(myAnimal);
        // ==================
    }

    public static void feed(Animal animal) {
        animal.eat();
        if (animal instanceof Dog) {
            Dog myDog = (Dog) animal;
            myDog.bark();
        }
    }


}
