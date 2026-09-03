package easy;

/**
 * Easy 8. Daemon Thread
 * Start a background daemon thread that loops forever printing a heartbeat,
 * and show that the JVM exits as soon as the main thread finishes, without
 * waiting for the daemon.
 **/
public class Task8 {
    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Thread heartbeat = new Thread(() -> {
            while (true) {
                System.out.println("heartbeat...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        heartbeat.setDaemon(true);
        heartbeat.start();

        Thread.sleep(500);
        System.out.println("main thread finished, JVM will exit even though the daemon is still running");
    }
}
