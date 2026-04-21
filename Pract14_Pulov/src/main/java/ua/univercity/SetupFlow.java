package ua.univercity;

public class SetupFlow {

    @Step(order = 2)
    private void loadConfig() {
        System.out.println("Loading configuration...");
    }

    @Step(order = 1)
    public void initDatabase() {
        System.out.println("Initializing database...");
    }

    @Step(order = 3)
    void startServer() {
        System.out.println("Starting server...");
    }
}