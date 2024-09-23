package classes.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllPossibleStreamOperations {
    public static void main(String[] args) {
        System.out.println("Basic Stream Operations");
//        1. **Convert a List to a Stream**:
//        Convert a `List<Integer>` to a `Stream<Integer>` and print each element.
        List<Integer> listOfIntegers = List.of(1,2,3,4,5,6,7,8,9,10,1,5,6);
        Stream<Integer> integerStream = listOfIntegers.stream();
        System.out.print("Stream of Integers : ");
        integerStream.forEach(e -> System.out.print(e + " "));
        System.out.println();
//        2. **Filter Even Numbers from a List**:
//        Given a list of integers, filter out even numbers using streams.
        System.out.print("Even Numbers : ");
        listOfIntegers.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print(e + " "));
        System.out.println();
//        3. **Find the Maximum Number**:
//        Given a list of integers, find the maximum value using the `max` method in streams.
        Optional<Integer> maxValue = listOfIntegers.stream().max(Integer::compareTo);
        System.out.println("Max : " + maxValue.get());
//        4. **Sum of Numbers**:
//        Given a list of integers, calculate the sum of the numbers using the `sum` method.
        int sumOfIntegers = listOfIntegers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sumOfIntegers : " + sumOfIntegers);
//        5. **Convert List of Strings to Uppercase**:
//        Convert a list of strings to uppercase using `map()` in streams.
        List<String> stringList = List.of("One", "Two", "Three", "Four", "Five", "Three", "Four", "Five", "ABCDEFGH");
        List<String> convertedStringList = stringList.stream().map(String::toUpperCase).toList();
        System.out.println("convertedStringList : " + convertedStringList);
//        6. **Find First Element**:
//        Given a list of strings, find the first element that starts with the letter "F" using `findFirst()`.
        Optional<String> findFirstStartsWithF = stringList.stream().filter(e -> e.startsWith("F")).findFirst();
        System.out.println("findFirstStartsWithF : " + findFirstStartsWithF.get());
//        7. **Collect Stream to List**:
//  Filter out strings starting with a vowel from a list and collect the result back into a list using `collect(Collectors.toList())`.
        List<String> collectVowelStartingWords = stringList.stream().filter(
                s -> s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u")
                || s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U")
        ).collect(Collectors.toList());
        System.out.println("collectVowelStartingWords : " + collectVowelStartingWords);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Intermediate Stream Operations");
//        8. **Sort List of Strings**:
//        Sort a list of strings alphabetically using streams.
        List<String> sortedAlphabetically = stringList.stream().sorted().toList();
        System.out.println("sortedAlphabetically : " + sortedAlphabetically);
//        9. **Count Elements Matching a Condition**:
//        Count how many strings in a list are longer than 3 characters using `count()`.
        long countOfGreaterThan3Chars = stringList.stream().filter(s -> s.length() > 3).count();
        System.out.println("countOfGreaterThan3Chars " + countOfGreaterThan3Chars);
//        10. **Remove Duplicates from a List**:
//        Given a list of integers, remove duplicates using streams and collect them into a `Set`.
        Set<Integer> uniqueIntegers = listOfIntegers.stream().collect(Collectors.toSet());
        System.out.println("uniqueIntegers : " + uniqueIntegers);
//        11. **Concatenate Strings**:
//        Concatenate a list of strings using streams and `Collectors.joining()`.
        String concatenatedStrings = stringList.stream().collect(Collectors.joining());
        System.out.println("concatenatedStrings : " + concatenatedStrings);
//        12. **FlatMap Example**:
//        Given a list of lists (e.g., `List<List<String>>`), flatten it into a single list using `flatMap()`.
        List<List<String>> listOfStringList = List.of(List.of("A", "B", "C", "D"), List.of("E", "F", "G", "H"));
        List<String> flatMapStrings = listOfStringList.stream().flatMap(Collection::stream).toList();
        System.out.println("flatMapStrings : " + flatMapStrings);
//        13. **Group Strings by Length**:
//        Group a list of strings by their length using `Collectors.groupingBy()`.
        Map<Integer, List<String>> stringsGroupingBy = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("stringsGroupingBy : " + stringsGroupingBy);
//        14. **Partition List into Odd and Even Numbers**:
//        Partition a list of integers into two lists, one with even numbers and one with odd numbers, using `Collectors.partitioningBy()`.
        Map<Boolean, List<Integer>> listPartition = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("listPartition : " + listPartition);
//        15. **Find the Second Largest Number**:
//        Find the second largest number in a list of integers using streams.
//
        Integer secondHighestNumber = listOfIntegers.stream().sorted((i1, i2) -> i2 - i1).skip(1).findFirst().get();
        System.out.println("secondHighestNumber : " + secondHighestNumber);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Advanced Stream Operations");
//        16. **Find N Largest Numbers**:
//        Find the N largest numbers in a list using `sorted()`, `limit()`, and `collect()`.
        int N = 3;
        List<Integer> nLargestNumber = listOfIntegers.stream().sorted((i1, i2) -> i2 - i1).limit(N).collect(Collectors.toList());
        System.out.println(nLargestNumber);
//        17. **Convert List of Objects to Map**:
//        Given a list of `Employee` objects with `name` and `age` fields, convert the list to a map where the key is the name and the value is the age.
        List<Employee> employeeList = employeesList();
        Map<String, Integer> nameAndAgeMap = employeeList.stream().collect(Collectors.toMap(Employee::getName, Employee::getAge));
        System.out.println(nameAndAgeMap);
//        18. **Parallel Stream Example**:
//        Convert a list of integers to a parallel stream and compute the sum of squares using `parallel()`.
        int sumOfSquares = listOfIntegers.parallelStream().map(i -> i * i).mapToInt(Integer::intValue).sum();
        System.out.println("sumOfSquares : " + sumOfSquares);
//        19. **Stream of Primitive Types**:
//        Use `IntStream` to generate a stream of numbers from 1 to 100 and find the average of these numbers.
        IntStream int100Stream = IntStream.range(1, 100);
        OptionalDouble averageOf100Integers = int100Stream.boxed().mapToInt(Integer::intValue).average();
        System.out.println("averageOf100Integers : " + averageOf100Integers.getAsDouble());
//        20. **Reduce Example**:
//        Implement a custom reduce operation to concatenate all elements of a list of strings into a single string, separated by commas.
        Optional<String> customReduceToConcatenateStrings = stringList.stream().reduce((s1, s2) -> s1 + "," + s2);
        System.out.println("customReduceToConcatenateStrings : " + customReduceToConcatenateStrings.get());
//        21. **Skip and Limit Operations**:
//        Given a list of integers, skip the first 2 elements and limit the result to 3 elements, then print them using streams.
        listOfIntegers.stream().skip(2).limit(3).forEach(System.out::println);
//        22. **Convert Array to Stream**:
//        Convert an array of integers to a stream and find the sum of all elements.
        int[] integerArray = {1,2,3,4,5,6,7,8,9,10};
        int sumOfArrayIntegers = Arrays.stream(integerArray).boxed().mapToInt(Integer::intValue).sum();
        System.out.println("sumOfArrayIntegers : " + sumOfArrayIntegers);
//        23. **Filter, Map, and Collect**:
//        Given a list of `Employee` objects, filter out employee older than 30, then create a list of their names using `map()` and `collect()`.
        List<String> collectedOlderThan30Employees = employeeList.stream()
                .filter(e -> e.getAge() > 30).map(Employee::getName).collect(Collectors.toList());
        System.out.println("collectedOlderThan30Employees : " + collectedOlderThan30Employees);
//        24. **Stream with Custom Comparator**:
//        Sort a list of `Employee` objects by their salary in descending order using a custom comparator and streams.
//
        List<Employee> employeesSalaryDescOrder = employeeList.stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).toList();
        System.out.println("employeesSalaryDescOrder : " + employeesSalaryDescOrder);
//        25. **Generate a Fibonacci Series**:
//        Use `Stream.iterate()` to generate the first N elements of the Fibonacci series.
        N = 10;
        List<Integer> fibonnociSeries = Stream.iterate(new int[]{0, 1}, fb -> new int[]{fb[1], fb[0] + fb[1]})
                .limit(N)
                .map(fb -> fb[0])
                .toList();
        System.out.println(fibonnociSeries);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Edge Cases and Special Scenarios");
//        26. **Find the Longest Word in a File**:
//        Read string list use streams to find the longest word.
//
        Optional<String> longestWord = stringList.stream().max(Comparator.comparingInt(String::length));
        System.out.println("longestWord : " + longestWord);
//        27. **Stream of Random Numbers**:
//        Generate an infinite stream of random numbers between 1 and 100 using `Stream.generate()` and collect the first 10 numbers into a list.
        List<Integer> randomNumbersList = Stream.generate(() -> IntStream.range(1, 100)).flatMap(IntStream::boxed).limit(10).toList();
        System.out.println("randomNumbersList : " + randomNumbersList);
//        28. **Stream of Objects**:
//        Create a stream of custom objects (e.g., `Employee`) and filter out objects based on a specific field, such as `salary > 10000`.
        List<Employee> customFilterBySalary = employeeList.stream().filter(e -> e.getSalary() > 10000).toList();
        System.out.println("customFilterBySalary : " + customFilterBySalary);
//        29. **Find Distinct Elements in a List**:
//        Given a list of strings with duplicates, find distinct strings ignoring case sensitivity.
        List<String> distinctStrings = stringList.stream().map(String::toLowerCase).distinct().toList();
        System.out.println("distinctStrings : " + distinctStrings);
//        30. **Filter and Sort Complex Objects**:
//        Given a list of `Employee` objects, filter out employees with age greater than 25, then sort the remaining employees by their names.
        List<Employee> filteredEmployeesAndSorted = employeeList.stream()
                .filter(e -> e.getAge() > 25).sorted(Comparator.comparing(Employee::getName)).toList();
        System.out.println("filteredEmployeesAndSorted : " + filteredEmployeesAndSorted);
        Map<String, Long> collectStringsByCounting = stringList.stream().collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));
        System.out.println("collectStringsByCounting : " + collectStringsByCounting);
        String temp = "this is a simple string testing";
        Map<String, Long> stringCollectionByChars = Arrays.stream(temp.replaceAll(" ", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("stringCollectionByChars : " + stringCollectionByChars);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Combining Streams and Optional");
//        31. **Find First Element Greater Than 50**:
//        Given a list of integers, use `findFirst()` to return an `Optional<Integer>` for the first number greater than 50.
        int100Stream = IntStream.range(1, 100);
        Optional<Integer> findFirstGreaterThan50 = int100Stream.boxed().filter(i -> i > 50).findFirst();
        System.out.println("findFirstGreaterThan50 : " + findFirstGreaterThan50);
//        32. **Get a Default Value if Stream is Empty**:
//        Given a stream that might be empty, return a default value if no elements are found using `orElse()` on `Optional`.
        Stream<String> emptyObjectStream = Stream.empty();
        String noElementsAreFound = emptyObjectStream.findFirst().orElse("no elements are found");
        System.out.println("noElementsAreFound : " + noElementsAreFound);
//        33. **Handle Null Values in Stream**:
//        Filter out `null` values from a list of strings using streams.
        Stream<String> stringStreamWithNullValues = Stream.of("One", null, "Two", null, "Three", null, "Four");
        List<String> withoutNullStrings = stringStreamWithNullValues.filter(Objects::nonNull).toList();
        System.out.println("withoutNullStrings : " + withoutNullStrings);
//        34. **Min and Max with Comparator**:
//        Find the employee with the minimum and maximum salary from a list of `Employee` objects using a custom comparator.
        Optional<Employee> maxEmployeeSalary = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("maxEmployeeSalary : " + maxEmployeeSalary);
        Optional<Employee> minEmployeeSalary = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("minEmployeeSalary : " + minEmployeeSalary);
//        35. **Joining Strings with Delimiters**:
//        Given a list of strings, join them with a delimiter (e.g., comma, semicolon) using `Collectors.joining()`.
        String joiningStringsWIthComma = stringList.stream().collect(Collectors.joining(","));
        System.out.println("joiningStringsWIthComma : " + joiningStringsWIthComma);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Advanced Use Cases");
//        36. **Parallel Processing with Stream**:
//        Use parallel streams to process a list of numbers in parallel, calculating their square and summing the result.
        int parallelStreamSum = listOfIntegers.parallelStream().map(i -> i * i).mapToInt(Integer::intValue).sum();
        System.out.println("parallelStreamSum : " + parallelStreamSum);
//        37. **Lazy Evaluation in Streams**:
//        Explain how lazy evaluation works in streams with an example that demonstrates when intermediate operations are executed.
        List<String> wordsList = List.of("apple", "banana", "cherry", "date", "elderberry");
        Stream<String> wordStream = wordsList.stream().filter(w -> w.length() > 5).map(String::toUpperCase);
        System.out.println("Intermediate Operations Completed but Not Printed Unless it called");
        List<String> listOfWords = wordStream.toList();
        System.out.println("Intermediate Operations collecting to list and printing here : " + listOfWords);
    }

    public static List<Employee> employeesList() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(6, "Six", 43, "Male", "Security", 2016, 9500.0, "Pune"));
        employeeList.add(new Employee(7, "Seven", 35, "Male", "Finance", 2010, 27000.0, "Pune"));
        employeeList.add(new Employee(3, "Three", 29, "Male", "Infrastructure", 2012, 18000.0, "Hyderabad"));
        employeeList.add(new Employee(8, "Eight", 31, "Male", "Development", 2015, 34500.0, "Pune"));
        employeeList.add(new Employee(9, "Nine", 24, "Female", "Sales", 2016, 11500.0, "Hyderabad"));
        employeeList.add(new Employee(10, "Ten", 25, "Female", "Sales", 2009, 22500.0, "Pune"));
        employeeList.add(new Employee(2, "Two", 25, "Male", "Sales", 2015, 13500.0, "Hyderabad"));
        employeeList.add(new Employee(4, "Four", 28, "Female", "Development", 2014, 32500.0, "Pune"));
        employeeList.add(new Employee(5, "Five", 27, "Female", "HR", 2013, 22700.0, "Pune"));
        employeeList.add(new Employee(1, "One", 32, "Female", "HR", 2011, 25000.0, "Hyderabad"));

        return employeeList;
    }
}
