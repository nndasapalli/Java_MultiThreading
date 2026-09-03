package advanced;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Advanced 6. Custom ThreadPoolExecutor with a Rejection Policy
 * Build a ThreadPoolExecutor with a small bounded queue and a custom
 * RejectedExecutionHandler, then flood it with more tasks than it can hold
 * to see the rejection policy kick in.
 **/
public class Task6 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                (runnable, exec) -> System.out.println("rejected a task, queue is full")
        );

        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("running task " + taskId);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
