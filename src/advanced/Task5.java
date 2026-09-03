package advanced;

/**
 * Advanced 5. ForkJoinPool with RecursiveTask
 * Sum a large array in parallel by recursively splitting it into halves
 * with a RecursiveTask once a chunk gets small enough to sum directly.
 **/
public class Task5 {
    public static void main(String[] args) {
        int[] numbers = new int[10_000];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        // Write your code here
    }
}
