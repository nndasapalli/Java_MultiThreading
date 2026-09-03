package easy;

/**
 * Easy 4. Thread.sleep and Interleaving
 * Start two threads that each print their name five times with a short sleep
 * between prints, so the output interleaves.
 **/
public class Task4 {
    static class MyThread implements Runnable{
        @Override
        public void run(){
            for(int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Write your code here
        Thread t1 = new Thread(new Task4.MyThread());
        Thread t2 = new Thread(new Task4.MyThread());

        t1.setName("MyThread-1");
        t2.setName("MyThread-2");

        t1.start();
        t2.start();
    }
}
