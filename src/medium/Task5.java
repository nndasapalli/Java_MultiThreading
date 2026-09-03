package medium;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Medium 5. CyclicBarrier
 * Three threads each do phase-1 work, then wait at a CyclicBarrier until
 * every thread has reached it, then all continue with phase-2 work together.
 **/
public class Task5 {
    public static void main(String[] args) {
        // Write your code here
        int partyCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(partyCount, () -> System.out.println("all threads reached the barrier"));
        for (int i = 1; i <= partyCount; i++) {
            int workerId = i;
            new Thread(() -> {
                System.out.println("worker " + workerId + " phase 1");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("worker " + workerId + " phase 2");
            }).start();
        }
    }
}
