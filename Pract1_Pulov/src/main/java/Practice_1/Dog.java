package Practice_1;

import java.util.Objects;

public class Dog extends Animal{

    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating pyszne mięso!");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }


    @Override
    public String toString() {
        return "Dog{" + super.toString() + '\'' +
                "breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }
}
