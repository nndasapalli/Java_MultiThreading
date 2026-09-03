package easy;

/**
 * Easy 1. Create a Thread by Extending Thread
 * Create a class that extends Thread, override run() to print numbers 1 to 5,
 * then start it from main().
 **/
public class Task1 {

    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }
}
