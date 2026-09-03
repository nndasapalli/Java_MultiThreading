package medium;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Medium 3. ReentrantLock
 * Replace a synchronized counter increment with a ReentrantLock, remembering
 * to unlock in a finally block.
 **/
public class Task3 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Task3 counter = new Task3();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        };
        Thread threadA = new Thread(task);
        Thread threadB = new Thread(task);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("count : " + counter.count);
    }
}
