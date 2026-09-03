package medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Medium 7. Lock-Free Counter with AtomicInteger
 * Two threads increment a shared counter 1000 times each without any
 * explicit locking, using AtomicInteger instead.
 **/
public class Task7 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        AtomicInteger count = new AtomicInteger(0);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) count.incrementAndGet();
        };
        Thread threadA = new Thread(task);
        Thread threadB = new Thread(task);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("count : " + count.get());
    }
}
