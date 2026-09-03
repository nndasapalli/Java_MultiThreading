package medium;

import java.util.concurrent.CountDownLatch;

/**
 * Medium 4. CountDownLatch
 * Start 3 worker threads that each do some work, and make the main thread
 * wait until all 3 have finished using a CountDownLatch.
 **/
public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        int workerCount = 3;
        CountDownLatch latch = new CountDownLatch(workerCount);
        for (int i = 1; i <= workerCount; i++) {
            int workerId = i;
            new Thread(() -> {
                System.out.println("worker " + workerId + " starting");
                try {
                    Thread.sleep(100L * workerId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("worker " + workerId + " done");
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("all workers finished");
    }
}
