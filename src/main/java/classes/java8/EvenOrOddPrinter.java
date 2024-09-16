package classes.java8;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class EvenOrOddPrinter {

    private static final Object object = new Object();
    private static final IntPredicate evenPredicate = t -> t%2==0;
    private static final IntPredicate oddPredicate = t -> t%2!=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOrOddPrinter.print(oddPredicate));
        CompletableFuture.runAsync(() -> EvenOrOddPrinter.print(evenPredicate));
        Thread.sleep(1000);
    }

    public static void print(IntPredicate intPredicate) {
        IntStream.rangeClosed(1,10).filter(intPredicate).forEach(EvenOrOddPrinter::execute);
    }
    public static void execute(int number) throws RuntimeException {
        synchronized (object) {
            try {
                out.println(Thread.currentThread().getName()+" : "+number);
                object.notifyAll();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
