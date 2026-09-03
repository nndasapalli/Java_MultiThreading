package advanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Advanced 4. CompletableFuture Chaining
 * Fetch a "user id" asynchronously, then asynchronously transform it into a
 * greeting, then combine it with a separately fetched "time of day" string.
 **/
public class Task4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write your code here
        CompletableFuture<String> greeting = CompletableFuture
                .supplyAsync(() -> 42)
                .thenApply(userId -> "Hello, user-" + userId);

        CompletableFuture<String> timeOfDay = CompletableFuture.supplyAsync(() -> "morning");

        CompletableFuture<String> combined = greeting.thenCombine(timeOfDay,
                (greetingText, time) -> greetingText + ", good " + time + "!");

        System.out.println(combined.get());
    }
}
