package advanced;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Advanced 7. Multi-Producer / Multi-Consumer with a Poison Pill
 * Two producers push numbers onto a shared queue, two consumers drain it,
 * and once producers finish, poison-pill values tell each consumer to stop
 * so the program shuts down cleanly.
 **/
public class Task7 {
    private static final Integer POISON_PILL = -1;

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        int producerCount = 2;
        int consumerCount = 2;

        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    int value = queue.take();
                    if (value == POISON_PILL) break;
                    System.out.println(Thread.currentThread().getName() + " consumed " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread[] producers = new Thread[producerCount];
        for (int i = 0; i < producerCount; i++) {
            producers[i] = new Thread(producer, "producer-" + i);
            producers[i].start();
        }
        Thread[] consumers = new Thread[consumerCount];
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(consumer, "consumer-" + i);
            consumers[i].start();
        }

        for (Thread p : producers) p.join();
        for (int i = 0; i < consumerCount; i++) queue.put(POISON_PILL);
        for (Thread c : consumers) c.join();

        System.out.println("all producers and consumers finished");
    }
}
