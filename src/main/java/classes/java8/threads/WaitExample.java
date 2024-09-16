package classes.java8.threads;

import static java.lang.System.*;

public class WaitExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    out.println("Thread is waiting");
                    lock.wait(); // Thread waits until notified
                    out.println("Thread is resumed after wait");
                } catch (InterruptedException e) {
                    err.println("Exception : " + e.getMessage());
                }
            }
        });

        waitingThread.start();

        // Sleep to simulate some processing time
        Thread.sleep(5000);

        synchronized (lock) {
            lock.notifyAll(); // Notify the waiting thread
            out.println("Thread is notified");
        }
    }
}
