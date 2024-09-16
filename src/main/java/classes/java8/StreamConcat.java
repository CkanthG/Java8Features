package classes.java8;

import java.util.stream.Stream;

public class StreamConcat {

    public void concat() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> integerStream1 = Stream.of(6, 7, 8, 9);
        Stream<Integer> stream = Stream.concat(integerStream, integerStream1);
        int sum = stream.mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}
