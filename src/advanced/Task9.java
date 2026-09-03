package advanced;

import java.util.concurrent.Exchanger;

/**
 * Advanced 9. Exchanger
 * Two threads each build their own message, then use an Exchanger to swap
 * messages with each other at a synchronization point.
 **/
public class Task9 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Exchanger<String> exchanger = new Exchanger<>();

        Thread threadA = new Thread(() -> {
            try {
                String received = exchanger.exchange("message from thread-A");
                System.out.println("thread-A received : " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                String received = exchanger.exchange("message from thread-B");
                System.out.println("thread-B received : " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
