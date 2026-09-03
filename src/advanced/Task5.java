package advanced;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Advanced 5. ForkJoinPool with RecursiveTask
 * Sum a large array in parallel by recursively splitting it into halves
 * with a RecursiveTask once a chunk gets small enough to sum directly.
 **/
public class Task5 {
    private static final int THRESHOLD = 1000;

    static class SumTask extends RecursiveTask<Long> {
        private final int[] numbers;
        private final int start;
        private final int end;

        SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) sum += numbers[i];
                return sum;
            }
            int mid = start + (end - start) / 2;
            SumTask left = new SumTask(numbers, start, mid);
            SumTask right = new SumTask(numbers, mid, end);
            left.fork();
            long rightResult = right.compute();
            long leftResult = left.join();
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        // Write your code here
        int[] numbers = new int[10_000];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        ForkJoinPool pool = new ForkJoinPool();
        long total = pool.invoke(new SumTask(numbers, 0, numbers.length));
        System.out.println("total : " + total);
    }
}
