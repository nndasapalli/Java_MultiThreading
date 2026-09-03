package medium;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Medium 6. Producer-Consumer with BlockingQueue
 * A producer thread puts numbers 1 to 10 onto a bounded BlockingQueue, and a
 * consumer thread takes and prints them, blocking automatically when the
 * queue is full or empty.
 **/
public class Task6 {
    public static void main(String[] args) {
        // Write your code here
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.println("produced : " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int value = queue.take();
                    System.out.println("consumed : " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
