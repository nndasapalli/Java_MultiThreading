package easy;

/**
 * Easy 6. Fix a Race Condition with synchronized
 * Multiple threads increment a shared counter 1000 times each. Make the
 * increment method synchronized so the final count is always correct.
 **/
public class Task6 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Task6 counter = new Task6();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
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
