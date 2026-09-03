package advanced;

/**
 * Advanced 1. Avoid Deadlock with Lock Ordering
 * Two threads each need locks A and B. Acquiring them in inconsistent order
 * can deadlock; fix it by always acquiring the locks in the same, agreed
 * order.
 **/
public class Task1 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
    }
}
