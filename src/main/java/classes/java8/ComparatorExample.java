package classes.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

public class ComparatorExample {

    public void comparatorUse() {
        List<String> list = Arrays.asList("90", "100", "-1", "20");
        list.sort((o1, o2) -> {
            Double d1 = Double.parseDouble(o1);
            Double d2 = Double.parseDouble(o2);
            return d1.compareTo(d2);
        });
        out.println(list);
    }

    public static void minMax() {
        List<Integer> list = Arrays.asList(1000,1,10,2,3,5,4,100,20,20);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        out.println("Min "+min.get()+" & Max "+max.get());
        boolean b = list.stream().allMatch((x) -> x % 2 == 0);
        out.println("Stream allMatch "+b);
        boolean status = list.stream().anyMatch((x) -> x % 2 == 0);
        out.println("Stream anyMatch "+status);
        long count = list.size();
        out.println("list count "+count);
        Stream<Integer> distinct = list.stream().distinct();
        out.print("distinct stream ");
        distinct.forEach(x -> out.print(x +" "));
        out.println();
        Optional<Integer> any = list.stream().findAny();
        out.println("Stream findAny "+any);
        Optional<Integer> first = list.stream().findFirst();
        out.println("Stream findFirst "+first);
        Stream<Integer> limit = list.stream().limit(4);
        out.println("Stream limit ");
        limit.forEach(out::println);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        out.println("Stream reduce "+reduce);
        Stream<Integer> mapStream = list.stream().map(i -> i * 2);
        out.println("Stream map");
        mapStream.forEach(out::println);
        Stream<Integer> skip = list.stream().skip(5);
        out.println("Stream skip");
        skip.forEach(out::println);
        out.println("Stream sort");
        list.stream().sorted().forEach(out::println);

        list.sort((Integer::compareTo));
        out.println(list);
    }

    public static void method() {
        List<String> list = Arrays.asList("ram", "sita", "hanuma", "laxmana", "ravana", "dasharadha");
        List<String> collect = list.stream().filter(e -> e.length() > 5)
                .peek(e -> out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> out.println("Mapped value: " + e))
                .toList();
        out.println(collect);
    }

    public static void main(String[] args) {
        minMax();
        method();
    }
}
