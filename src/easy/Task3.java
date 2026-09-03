package easy;

/**
 * Easy 3. Thread Name and Priority
 * Create a thread, give it a custom name and the maximum priority, then print
 * its name and priority from inside run().
 **/
public class Task3 {
    public static void main(String[] args) {
        // Write your code here
        Thread thread = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println("name : " + current.getName());
            System.out.println("priority : " + current.getPriority());
        });
        thread.setName("worker-thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
