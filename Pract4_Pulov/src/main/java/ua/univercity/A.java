package ua.univercity;

class A {
    public void process(Object o) {
        System.out.println("Class A: process(Object)");
    }
}

class B extends A {
    @Override
    public void process(Object o) {
        System.out.println("Class B: process(Object) - Overridden");
    }

    public void process(String s) {
        System.out.println("Class B: process(String) - Overloaded");
    }
}