package classes.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class CollectorsTeeing {

    public void teeing() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, Integer> minMaxMap = integers.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (e1, e2) -> Map.of("max", e1.get(), "min", e2.get())
                ));
        out.println(minMaxMap);
    }
}
