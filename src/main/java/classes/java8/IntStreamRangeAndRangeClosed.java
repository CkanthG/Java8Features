package classes.java8;

import java.util.stream.IntStream;

public class IntStreamRangeAndRangeClosed {

    public void rangeAndRangeClosed() {
        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }
}
