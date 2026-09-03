package medium;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Medium 8. ThreadLocal
 * SimpleDateFormat is not thread-safe. Give each thread its own instance
 * with ThreadLocal so multiple threads can format dates concurrently
 * without interfering with each other.
 **/
public class Task8 {
    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Runnable task = () -> {
            String formatted = formatter.get().format(new Date());
            System.out.println(Thread.currentThread().getName() + " : " + formatted);
        };
        Thread threadA = new Thread(task, "thread-A");
        Thread threadB = new Thread(task, "thread-B");
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
