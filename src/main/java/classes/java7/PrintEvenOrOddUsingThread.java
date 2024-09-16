package classes.java7;

import static java.lang.System.*;

public class PrintEvenOrOddUsingThread implements Runnable{
    final Object object;
    static int count = 1;
    static int maxCount = 10;

    public PrintEvenOrOddUsingThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while(count <= maxCount) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    try {
                        out.println("Thread Name : " + Thread.currentThread().getName()+" value : "+count);
                        if (count == maxCount)
                            break;
                        count++;
                        object.wait();
                    } catch (InterruptedException exception) {
                        err.println("Exception : " + exception.getMessage());
                    }
                }
            } else if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    out.println("Thread Name : " + Thread.currentThread().getName()+" value : "+count);
                    count++;
                    object.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Runnable r1 = new PrintEvenOrOddUsingThread(lock);
        Runnable r2 = new PrintEvenOrOddUsingThread(lock);
        new Thread(r1, "even").start();
        new Thread(r2, "odd").start();
        Thread.sleep(1000);
    }
}
