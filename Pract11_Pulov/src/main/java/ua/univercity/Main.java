package ua.univercity;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //! === TASK ONE ===
        System.out.println("=== TASK ONE ===");

        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2017, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java")),
                new Book("Note tutor", "Frederik Chopin", 2017,  List.of("tutor, music")),
                new Book("History of Poland", "Irzhek Gaba", 1234, List.of("history, Poland"))
        );

        List<String> result = books.stream()
                .filter(b -> b.year() > 2015)
                .map(b -> b.title().toUpperCase())
                .sorted()
                .limit(3)
                .toList();

        System.out.println(result);




        //! === TASK TWO ===
        System.out.println("\n\n=== TASK TWO ===");

        System.out.println("| Uniq sorted tags");
        List<String> uniqueTags = books.stream()
                .flatMap(book -> book.tags().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println(uniqueTags);


        System.out.println("\n| Analyze");
        Map<String, Long> tagFrequency = books.stream()
                .flatMap(book -> book.tags().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(tagFrequency);


        System.out.println("\n| Top-N tags ===");
        int topN = 3;
        tagFrequency.entrySet().stream()
                .sorted(
                        Map.Entry.<String, Long>comparingByValue().reversed()
                                .thenComparing(Map.Entry::getKey)
                )
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));



        //! === TASK THREE ===
        System.out.println("\n\n=== TASK THREE ===");

        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );

        System.out.println("| Income (toMap merge)");
        Map<String, Integer> revenueByProduct = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));

        System.out.println(revenueByProduct);


        System.out.println("\n| Transaction quantity (groupingBy)");
        Map<String, Long> transactionsByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));

        System.out.println(transactionsByCustomer);


        //! === TASK FOUR ===
        System.out.println("\n\n=== TASK FOUR ===");

        List<Result> results = List.of(
                new Success("Data downloaded successfully"),
                new Failure("Connection error"),
                new Success("Profile updated"),
                new Failure("Incorrect credentials"),
                new Failure("Server timeout")
        );

        System.out.println("| Count results");
        Map<Boolean, Long> counts = results.stream()
                .collect(Collectors.partitioningBy(
                        r -> r instanceof Success,
                        Collectors.counting()
                ));

        System.out.println("Count Success: " + counts.get(true));
        System.out.println("Count Failure: " + counts.get(false));


        System.out.println("\n| Collect info");
        List<String> failureMessages = results.stream()
                .filter(r -> r instanceof Failure)
                .map(r -> ((Failure) r).message())
                .toList();

        System.out.println("Errors list: " + failureMessages);
    }
}