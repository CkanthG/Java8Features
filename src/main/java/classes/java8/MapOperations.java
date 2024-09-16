package classes.java8;

import classes.models.Employee;
import classes.models.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

public class MapOperations {

    public void userStreamMapOperations() {
        List<User> users = Stream.of(
                new User("sreekanth", "9848962806", Arrays.asList("sreekanthgaddoju@gmail.com", "ssist@gmail.com")),
                new User("devansh", "9848962807", Arrays.asList("devanshgaddoju@gmail.com", "dev@gmail.com"))
        ).toList();
        List<String> phoneNumbersList = users.stream().map(User::getPhone).collect(Collectors.toList());
        out.println(phoneNumbersList);
    }

    public void userStreamFlatMapOperations() {
        List<User> users = Stream.of(
                new User("sreekanth", "9848962806", Arrays.asList("sreekanthgaddoju@gmail.com", "ssist@gmail.com")),
                new User("devansh", "9848962807", Arrays.asList("devanshgaddoju@gmail.com", "dev@gmail.com"))
        ).toList();
        List<String> emailList = users.stream().flatMap(user -> user.getEmail().stream()).collect(Collectors.toList());
        out.println(emailList);
    }

    public void findHighestSalary() {
        List<Employee> employeeList = Stream.of(
                new Employee(1, "Sowmya", "DEV", 500000),
                new Employee(2, "Devansh", "DEV", 200000),
                new Employee(3, "Sreekanth", "QA", 300000),
                new Employee(4, "Ckanth", "QA", 100000),
                new Employee(5, "Anil", "DEVOPS", 400000)
        ).toList();

        employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())
        )).entrySet().stream().filter(x -> x.getKey().equals("DEV")).forEach(
                x -> out.println(x.getKey() + " -> "+ x.getValue())
        );

        Map<String, Long> collectedEmployees = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDept, Collectors.counting()
        ));

        out.println("collectedEmployees: " + collectedEmployees);

        Comparator<Employee> salaryComp = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> salaryMap = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(salaryComp)))
        );
        out.println(salaryMap);
        Map<String, Employee> employeeMap = employeeList.stream().collect(
                Collectors.toMap(Employee::getDept, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary)))
        );
        out.println(employeeMap);
    }

    public static void sortEmployeeMap() {
        Map<Integer, Emp> map = new HashMap<>();
        map.put(1, new Emp(4, "Sowmya", "Hyderabad"));
        map.put(2, new Emp(2, "Devansh", "Bangalore"));
        map.put(3, new Emp(3, "Sreekanth", "Mumbai"));

        List<String> strings = map.entrySet().stream().flatMap(e -> Stream.of(e.getValue().getName().toUpperCase())).toList();
        out.println("uppercase strings:" + strings);

        HashMap<Integer, Emp> collect = map.entrySet().stream().sorted(
                (o1, o2) -> o2.getValue().getCity().compareTo(o1.getValue().getCity())
        ).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (k, v) -> k,
                HashMap::new));
        out.println(collect);
    }

    public static void arrayOperations() {
        int[] arr = {1,2,1,3,5,1,6,7,1};
        int lastIndex = arr.length - 1;
        for (int x = arr.length-1; x >= 0; x--) {
            if (arr[x] != 1) {
                arr[lastIndex] = arr[x];
                lastIndex --;
            }
        }
        for (int x = 0; x <= lastIndex; x ++) {
            arr[x] = 1;
        }
        for(int x : arr) {
            out.print(x + ",");
        }
    }

    public static void palindromeCheck() {
        String s = "aaha";
        String actual = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(actual)) {
            out.println("Palindrome");
        } else {
            out.println("Not Palindrome");
        }
    }

    public static void removeDuplicates() {
        int[] arr = {1,2,1,3,2,3,4,1,1,4,4,8}; // 3
        Set<Integer> set = new HashSet<>();
        Set<Integer> data = Arrays.stream(arr).filter(i -> !set.add(i)).boxed().collect(Collectors.toSet());
        for (int x : arr) {
            if (!data.contains(x)) {
                out.println(x);
            }
        }
    }

    public static void reverseArray() {
        int[] arr = {1,2,3,4,5,6};
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (j < i) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            } else break;
        }
        out.println(Arrays.toString(arr));
    }

    public static void removeDuplicatesFromString() {
        String s = "HappynewYear"; //
        Set<String> set = new HashSet<>();
        Set<String> collect = Arrays.stream(s.split("")).filter(set::add).collect(Collectors.toSet());
        out.println(collect);

        String[] str = s.split("");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Collections.addAll(linkedHashSet, str);
        linkedHashSet.forEach(out::print);
    }

    public static void main(String[] args) {
        sortEmployeeMap();
    }
}

class Emp {
    private Integer id;
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Emp(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
