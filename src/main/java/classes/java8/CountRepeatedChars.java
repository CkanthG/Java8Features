package classes.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountRepeatedChars {

    public void countRepeatedCharacters(String str) {
        String[] strings = str.split("");
        Map<String, Long> stringLongMap = Arrays.stream(strings).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );
        System.out.println(stringLongMap);
    }
}
