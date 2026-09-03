package easy;

/**
 * Easy 2. Create a Thread Using Runnable
 * Implement Runnable (with a lambda) to print numbers 1 to 5, then run it on a new Thread.
 **/
public class Task2 {
    static class counterThread implements Runnable{
        @Override
        public void run(){
            for(int i = 1 ; i <= 5 ; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // Write your code here
        Thread counterThread =  new Thread(new Task1.CounterThread());
        counterThread.start();
    }
}
