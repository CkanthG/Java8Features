package classes.sample;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.*;

// Implement a program that prints the numbers 1 .. 100 in ascending order
public class Printing1to100 {

    public static void print() {
        int[] a = IntStream.range(1, 100).toArray();
        Arrays.stream(a).asLongStream().forEach(out::print);
        out.println();
    }
    public static void main(String[] args) {
        print();
    }

}
