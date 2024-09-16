package classes.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTakeWhileAndDropWhile {

    public void takeWhileAndDropWhile() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> collectedResult = integers.stream()
                .takeWhile(n -> n < 5).collect(Collectors.toList());
        System.out.println(collectedResult);
        List<Integer> collected = integers.stream()
                .dropWhile(n -> n < 5).collect(Collectors.toList());
        System.out.println(collected);
        List<Integer> collect = integers.stream()
                .dropWhile(i -> i < 4)
                .takeWhile(i -> i < 7).collect(Collectors.toList());
        System.out.println(collect);
    }
}
