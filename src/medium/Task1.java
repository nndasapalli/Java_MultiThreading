package medium;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Medium 1. ExecutorService with a Fixed Thread Pool
 * Submit 5 Runnable tasks to a fixed thread pool of 2 threads and shut the
 * pool down cleanly once all tasks are done.
 **/
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println("task " + taskId + " run by " + Thread.currentThread().getName()));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
