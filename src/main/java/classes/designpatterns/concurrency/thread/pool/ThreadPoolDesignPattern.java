package classes.designpatterns.concurrency.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDesignPattern {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished execution of all threads");
    }
}
