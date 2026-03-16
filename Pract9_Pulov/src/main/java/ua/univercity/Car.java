package ua.univercity;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public static class Engine {
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        public int getHorsepower() {
            return horsepower;
        }
    }

    public Engine spec() {
        return new Engine(400);
    }
}
