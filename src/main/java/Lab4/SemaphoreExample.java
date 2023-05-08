package Lab4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final int MAX_THREADS = 5;
    private static final int MAX_PERMITS = 2;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(MAX_PERMITS);
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        for (int i = 1; i <= MAX_THREADS; i++) {
            executor.execute(new Task(semaphore, i));
        }

        executor.shutdown();
    }

    static class Task implements Runnable {

        private Semaphore semaphore;
        private int threadId;

        public Task(Semaphore semaphore, int threadId) {
            this.semaphore = semaphore;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + threadId + " is waiting for a permit.");
                semaphore.acquire();
                System.out.println("Thread " + threadId + " has acquired a permit.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Thread " + threadId + " has released a permit.");
            }
        }
    }
}