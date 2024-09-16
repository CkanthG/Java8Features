package classes.java8.threads;

import static java.lang.System.*;

public class ProducerConsumerExample {
    private static final Object lock = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (count == 0) {
                        out.println("Producer is waiting...");
                        lock.wait(); // Wait until notified
                    }
                    out.println("Producer consumed: " + count);
                    count = 0; // Reset count
                    lock.notify(); // Notify consumer thread
                } catch (InterruptedException e) {
                    err.println("Exception : " + e.getMessage());
                }
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                count = 1; // Produce an item
                out.println("Consumer produced: " + count);
                lock.notifyAll(); // Notify producer thread
                try {
                    lock.wait(); // Wait until notified
                } catch (InterruptedException e) {
                    err.println("Exception : " + e.getMessage());
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

