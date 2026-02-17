package ua.univercity;

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog movi cos typu gaav");
    }

    public void fetchStick() {
        System.out.println("Dog nesie panowie ten stick!");
    }
}
