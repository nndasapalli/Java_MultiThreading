package easy;

/**
 * Easy 7. Thread-Safe Bank Account with a synchronized Block
 * Two threads deposit and withdraw from a shared account concurrently.
 * Guard the balance updates with a synchronized block so it never goes
 * negative or loses updates.
 **/
public class Task7 {
    private int balance = 100;
    private final Object lock = new Object();

    public void withdraw(int amount) {
        synchronized (lock) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
    }

    public void deposit(int amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Write your code here
        Task7 account = new Task7();
        Thread depositor = new Thread(() -> {
            for (int i = 0; i < 100; i++) account.deposit(10);
        });
        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < 100; i++) account.withdraw(10);
        });
        depositor.start();
        withdrawer.start();
        depositor.join();
        withdrawer.join();
        System.out.println("balance : " + account.balance);
    }
}
