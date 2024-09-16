package classes.java8;

import java.util.stream.IntStream;

public class Pyramid {
    public static void main(String[] args) {
        int rows = 5;

        IntStream.range(1, rows + 1)
                .forEach(i -> {
                    IntStream.range(0, rows - i)
                            .forEach(j -> System.out.print(" "));
                    IntStream.range(0, 2 * i - 1)
                            .forEach(j -> System.out.print("*"));
                    System.out.println();
                });
    }
}
