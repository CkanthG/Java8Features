package classes.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class SortObjects {

    public void sort() {
        List<EmployeeObj> list = List.of(
                new EmployeeObj(1, "abc", 6000.00),
                new EmployeeObj(2, "def", 15000.00),
                new EmployeeObj(3, "xyz", 25000.00)
        );
        Optional<String> employeeName = list.stream().sorted((e1, e2) -> (int) (e2.employeeSalary() - e1.employeeSalary())).map(
                EmployeeObj::employeeName
        ).findFirst();
        out.println(employeeName);

        Integer[] arr = {2,4,6,8,3};
        Comparator<Integer> comparator = (a, b) -> b - a;
        Arrays.sort(arr, comparator);
        out.println(Arrays.toString(arr));
        Integer[] arr1 = {2,4,6,8,3};
        Arrays.sort(arr1);
        out.println(Arrays.toString(arr1));
        String s = "ab2cd5";
        long r = s.chars()
                        .filter(Character::isDigit)
                                .map(Character::getNumericValue)
                                        .sum();
        out.println(r);

        String[] str = {"abc bcd", "abc", "xyz rgd, abc", "abc"};

        Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().forEach(
                x -> {
                    if (x.getKey().equals("abc")) {
                        out.println(x.getKey() +" "+x.getValue());
                    }
                }
        );

        Arrays.stream(str).flatMap(i ->
        {
            Arrays.stream(i.split("")).collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
            ).entrySet().forEach(
                    x -> {
                        if (x.getKey().equals("abc")) {
                            out.println(x.getKey() +" "+x.getValue());
                        }
                    }
            );
            return null;
        });

        Arrays.stream(str).forEach(i -> {
            Arrays.stream(i.split(" ")).collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
            ).forEach((key, value) -> {
                // Check if the key is "a", "b", or "c" and then count it
                if (key.equals("abc")) {
                    out.println(key + " " + value);
                }
            });
        });

    }


    public static void main(String[] args) {
        new SortObjects().sort();
    }
}

record EmployeeObj(Integer employeeId, String employeeName, Double employeeSalary){}