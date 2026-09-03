package medium;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Medium 2. Callable and Future
 * Submit a Callable that computes the square of a number and read the
 * result back through the returned Future.
 **/
public class Task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write your code here
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> square = () -> {
            int number = 7;
            return number * number;
        };
        Future<Integer> future = executor.submit(square);
        System.out.println("result : " + future.get());
        executor.shutdown();
    }
}
