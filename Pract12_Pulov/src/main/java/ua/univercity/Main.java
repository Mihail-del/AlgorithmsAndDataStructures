package ua.univercity;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        //! === TASK ONE ===
        System.out.println("\n\n=== TASK ONE ===\n");

        Path testFile = Path.of("./Pract12_Pulov/src/main/payments.csv");
        Files.writeString(testFile, """
            id,email,status,amountCents
            1,user1@ex.com,PAID,1500
            2,user2@ex.com,NEW,200
            
            3,user3@ex.com,UNKNOWN_STATUS,500
            4,user4@ex.com,FAILED,bad_amount
            5,user5@ex.com,PAID,300
            invalid_format_line
            """);

        PaymentStats stats = PaymentLoader.loadWithStats(testFile);

        System.out.println("=== CSV Parsing Results ===");
        System.out.println("Valid payments loaded: " + stats.payments().size());
        System.out.println("Invalid lines skipped: " + stats.invalidLines());

        System.out.println("\nLoaded data:");
        stats.payments().forEach(System.out::println);

        Files.deleteIfExists(testFile);

        //! === TASK TWO ===
        System.out.println("\n\n=== TASK TWO ===\n");

        Path reportFile = Path.of("./Pract12_Pulov/src/main/report.txt");

        try {
            PaymentReportWriter.writeReport(reportFile, stats.payments(), stats.invalidLines());
            System.out.println("Report saved to " + reportFile.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error in report saving: " + e.getMessage());
        }

        //! === TASK THREE ===
        System.out.println("\n\n=== TASK THREE ===\n");

        Path inboxDir = Path.of("./Pract12_Pulov/src/main/practical-data/inbox");
        Path archiveDir = Path.of("./Pract12_Pulov/src/main/practical-data/archive");

        Files.createDirectories(inboxDir);
        Files.writeString(inboxDir.resolve("report_2026.txt"), "Important report data");
        Files.writeString(inboxDir.resolve("cache_A.tmp"), "Temporary cache data A");
        Files.writeString(inboxDir.resolve("cache_B.tmp"), "Temporary cache data B");
        Files.writeString(inboxDir.resolve("summary.txt"), "Summary text");

        System.out.println("| Starting Archiver");

        InboxArchiver.archiveTmpFiles(inboxDir, archiveDir);

        System.out.println("\n| Verification");
        System.out.println("Remaining in Inbox:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(inboxDir)) {
            for (Path p : stream) System.out.println(" - " + p.getFileName());
        }

        System.out.println("\nMoved to Archive:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(archiveDir)) {
            for (Path p : stream) System.out.println(" - " + p.getFileName());
        }

        //! === TASK FOUR ===
        System.out.println("\n\n=== TASK FOUR ===\n");

        Path baseDir = Path.of("practical-data/base-folder");

        System.out.println("| Valid Path");
        try {
            Path safePath = PathSafety.safeResolve(baseDir, "reports/2025.txt");
            System.out.println("SUCCESS. Resolved path is safe: " + safePath);
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n| Path Traversal Attempt");
        try {
            Path maliciousPath = PathSafety.safeResolve(baseDir, "../secret.txt");
            System.out.println("SUCCESS. Resolved path is safe: " + maliciousPath);
        } catch (IllegalArgumentException e) {
            System.err.println("BLOCKED: " + e.getMessage());
        }

    }
}