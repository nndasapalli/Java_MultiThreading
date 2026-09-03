package easy;

/**
 * Easy 5. Waiting for a Thread with join()
 * Start a worker thread that takes a moment to "compute" a result, then use
 * join() so the main thread waits for it to finish before reading the result.
 **/
public class Task5 {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            result = 42;
        });
        worker.start();
        worker.join();
        System.out.println("result : " + result);
    }
}
