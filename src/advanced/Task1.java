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
        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("thread-A holds lockA");
                synchronized (lockB) {
                    System.out.println("thread-A holds lockA and lockB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("thread-B holds lockA");
                synchronized (lockB) {
                    System.out.println("thread-B holds lockA and lockB");
                }
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("finished without deadlock because both threads acquire lockA before lockB");
    }
}
