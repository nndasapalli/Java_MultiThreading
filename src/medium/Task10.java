package medium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Medium 10. ExecutorService.invokeAll
 * Submit a batch of Callables that each compute a square, and use
 * invokeAll to run them all and collect every result once they've
 * completed.
 **/
public class Task10 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Write your code here
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> 1 * 1,
                () -> 2 * 2,
                () -> 3 * 3,
                () -> 4 * 4,
                () -> 5 * 5
        );
        List<Future<Integer>> futures = executor.invokeAll(tasks);
        for (Future<Integer> future : futures) {
            System.out.println("result : " + future.get());
        }
        executor.shutdown();
    }
}
