package medium;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Medium 9. ScheduledExecutorService
 * Schedule a task to run every 200ms, stop it after it has run 5 times, and
 * shut the scheduler down.
 **/
public class Task9 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger runCount = new AtomicInteger(0);

        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(() -> {
            int run = runCount.incrementAndGet();
            System.out.println("tick " + run);
        }, 0, 200, TimeUnit.MILLISECONDS);

        while (runCount.get() < 5) {
            Thread.sleep(50);
        }
        future.cancel(true);
        scheduler.shutdown();
    }
}
