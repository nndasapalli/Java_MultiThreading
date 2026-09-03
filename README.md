# Java_MultiThreading

A collection of Java multithreading & concurrency practice exercises, organized by difficulty.

## Structure

- `src/easy` — 8 tasks (Thread/Runnable basics, sleep, join, synchronized, daemon threads)
- `src/medium` — 10 tasks (ExecutorService, Callable/Future, ReentrantLock, CountDownLatch, CyclicBarrier, BlockingQueue, AtomicInteger, ThreadLocal, scheduling)
- `src/advanced` — 11 tasks (deadlock avoidance, ReadWriteLock, Semaphore, CompletableFuture, ForkJoinPool, custom ThreadPoolExecutor, multi-producer/consumer, LRU cache, Exchanger, Phaser, custom spinlock)

Each `TaskN.java` file contains a short problem description in a Javadoc comment, any given setup, and a `// Write your code here` placeholder to fill in with your own solution.

## Running

Each task is a standalone class with a `main` method, so it can be run directly:

```
javac src/easy/Task1.java -d out
java -cp out easy.Task1
```

Note: some output ordering is non-deterministic by nature of concurrent execution — interleaving may vary between runs.