package classes.java8;

import java.util.stream.Stream;

public class StreamIterate {
    public void streamIterate() {
        Stream.iterate(1, x -> x + 2)
                .limit(5)
                .forEach(System.out::println);
    }
}
