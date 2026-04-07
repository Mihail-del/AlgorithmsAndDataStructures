package ua.univercity;

import java.nio.file.Path;

public class PathSafety {
    public static Path safeResolve(Path base, String userInput) {

        Path resolvedPath = base.resolve(userInput);

        Path normalizedBase = base.normalize().toAbsolutePath();
        Path normalizedResolved = resolvedPath.normalize().toAbsolutePath();

        if (!normalizedResolved.startsWith(normalizedBase)) {
            throw new IllegalArgumentException("Path traversal attempt detected! Access denied for: " + userInput);
        }

        return normalizedResolved;
    }
}
