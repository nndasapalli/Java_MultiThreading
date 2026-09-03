package easy;

/**
 * Easy 4. Thread.sleep and Interleaving
 * Start two threads that each print their name five times with a short sleep
 * between prints, so the output interleaves.
 **/
public class Task4 {
    public static void main(String[] args) {
        // Write your code here
        Runnable printer = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread threadA = new Thread(printer, "thread-A");
        Thread threadB = new Thread(printer, "thread-B");
        threadA.start();
        threadB.start();
    }
}
