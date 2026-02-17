package ua.univercity;

import java.util.Optional;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}

public class UserRepository {

    public static Optional<User> findByEmail(String email) {
        if ("helenUkma@gmail.com".equals(email)) {
            return Optional.of(new User("Helen", email));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("--- Test: orElseGet ---");

        User defaultUser = findByEmail("unknown@gmail.com")
                .orElseGet(() -> new User("Default Guest", "guest@gmail.com"));

        System.out.println("Result: " + defaultUser);

        System.out.println("\n--- Test: orElseThrow ---");

        try {
            findByEmail("hacker@gmail.com")
                    .orElseThrow(() -> new IllegalArgumentException("Error: Critical user missing!"));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}