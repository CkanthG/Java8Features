package classes.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {

    public void partitioningBy() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> collect = integers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers : " + collect.get(Boolean.TRUE));
        System.out.println("Odd Numbers : " + collect.get(Boolean.FALSE));
    }
}
