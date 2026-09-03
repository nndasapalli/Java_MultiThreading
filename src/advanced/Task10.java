package advanced;

import java.util.concurrent.Phaser;

/**
 * Advanced 10. Phaser
 * Coordinate 3 threads through two phases of work using a Phaser: every
 * thread must finish phase 1 before any of them can start phase 2.
 **/
public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        int partyCount = 3;
        Phaser phaser = new Phaser(partyCount);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " phase 1");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " phase 2");
            phaser.arriveAndAwaitAdvance();
        };

        Thread[] threads = new Thread[partyCount];
        for (int i = 0; i < partyCount; i++) {
            threads[i] = new Thread(worker, "worker-" + i);
            threads[i].start();
        }
        for (Thread t : threads) t.join();
    }
}
