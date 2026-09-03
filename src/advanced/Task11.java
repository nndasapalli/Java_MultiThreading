package advanced;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Advanced 11. Custom Spinlock with compareAndSet
 * Implement a minimal spinlock using AtomicBoolean.compareAndSet as the CAS
 * primitive, then use it to protect a shared counter incremented by two
 * threads.
 **/
public class Task11 {
    static class SpinLock {
        private final AtomicBoolean locked = new AtomicBoolean(false);

        void lock() {
            while (!locked.compareAndSet(false, true)) {
                // busy-wait
            }
        }

        void unlock() {
            locked.set(false);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        SpinLock spinLock = new SpinLock();
        int[] count = {0};

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                spinLock.lock();
                try {
                    count[0]++;
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread threadA = new Thread(task);
        Thread threadB = new Thread(task);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("count : " + count[0]);
    }
}
