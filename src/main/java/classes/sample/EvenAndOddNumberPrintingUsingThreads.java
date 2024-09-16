package classes.sample;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.*;

// Use two threads, one thread printing even numbers, the other printing odd numbers only
public class EvenAndOddNumberPrintingUsingThreads {

    Runnable evenThread;
    Runnable oddThread;

    public void print() {
        int[] a = IntStream.range(1, 10).toArray();
        evenThread = () -> Arrays.stream(a).asLongStream().forEach(
                i -> {
                    if (i%2 != 0) {
                        out.println("Odd Number "+ i);
                    }
                }
        );
        new Thread(evenThread).start();
        oddThread = () -> Arrays.stream(a).asLongStream().forEach(
                i -> {
                    if (i%2 == 0) {
                        out.println("Even Number "+ i);
                    }
                }
        );
        new Thread(oddThread).start();
    }

    public static void main(String[] args) {
        new EvenAndOddNumberPrintingUsingThreads().print();
    }
}
