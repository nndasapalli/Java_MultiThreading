package advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Advanced 2. ReentrantReadWriteLock
 * Wrap a HashMap so many threads can read concurrently, but a write takes
 * an exclusive lock that blocks every reader and writer.
 **/
public class Task2 {
    private final Map<String, Integer> cache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Integer get(String key) {
        lock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(String key, Integer value) {
        lock.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Task2 store = new Task2();
        store.put("count", 0);

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                store.put("count", i);
                System.out.println("wrote count = " + i);
            }
        });

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("read count = " + store.get("count"));
            }
        });

        writer.start();
        reader.start();
        writer.join();
        reader.join();
    }
}
