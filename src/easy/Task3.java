package easy;

/**
 * Easy 3. Thread Name and Priority
 * Create a thread, give it a custom name and the maximum priority, then print
 * its name and priority from inside run().
 **/
public class Task3 {

    static class MyThread implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " is running with priority: " + Thread.currentThread().getPriority());
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());

        t1.setName("MyThread-1");
        t2.setName("MyThread-2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
