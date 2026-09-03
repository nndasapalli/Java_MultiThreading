package advanced;

import java.util.concurrent.Semaphore;

/**
 * Advanced 3. Semaphore
 * Simulate a pool of 2 database connections shared by 5 threads: each
 * thread must acquire a permit before "using" a connection and release it
 * afterwards, so at most 2 run at once.
 **/
public class Task3 {
    public static void main(String[] args) {
        // Write your code here
        Semaphore connectionPool = new Semaphore(2);

        for (int i = 1; i <= 5; i++) {
            int clientId = i;
            new Thread(() -> {
                try {
                    connectionPool.acquire();
                    System.out.println("client " + clientId + " acquired a connection");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("client " + clientId + " released the connection");
                    connectionPool.release();
                }
            }).start();
        }
    }
}
