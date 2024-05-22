package chapter30;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author karl xie
 */
public class Main {

    public static long time(ExecutorService executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();  // Tell timer we're ready
                try {
                    start.await();  // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // Tell timer we're done
                }
            });
        }

        ready.await();  // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown();  // And they're off!
        done.await();  // Wait for all workers to finish
        executor.shutdown();
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) {

        try {
            System.out.println(time(Executors.newCachedThreadPool(), 5, () -> System.out.println("1")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}