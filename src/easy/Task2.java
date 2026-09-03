package easy;

/**
 * Easy 2. Create a Thread Using Runnable
 * Implement Runnable (with a lambda) to print numbers 1 to 5, then run it on a new Thread.
 **/
public class Task2 {
    public static void main(String[] args) {
        // Write your code here
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
