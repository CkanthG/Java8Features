package classes.java8;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.*;

public class TwoObjectsComparison {

    public static void comparing() {
        Map<Cl1, String> map = new HashMap<>();
        map.put(new Cl1(3, "A"), "a");
        map.put(new Cl1(2, "C"), "a");
        map.put(new Cl1(1, "B"), "a");

        List<Map.Entry<Cl1, String>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Cl1::getName))).toList();
        out.println(entries);

    }

    public static void main(String[] args) {
        TwoObjectsComparison.comparing();
        TwoObjectsComparison.flatMap();
        TwoObjectsComparison.findHighestSalaryFromCl2();
    }

    public static void flatMap() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<Integer> integers = Stream.of(list1, list2, list3).flatMap(List::stream).toList();
        out.println(integers);
    }

    public static void findHighestSalaryFromCl2() {
        List<Cl2> list = new ArrayList<>();
        list.add(new Cl2(1, "sree", 5000.0));
        list.add(new Cl2(3, "dev", 3000.0));
        list.add(new Cl2(2, "sow", 10000.0));

        Optional<Cl2> first = list.stream().max(Comparator.comparing(Cl2::getSalary));
        first.ifPresent(cl2 -> out.println(cl2.getName()));
    }
}

class Cl2 {
    private Integer id;
    private String name;
    private double salary;

    public Cl2(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Cl1 {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Cl1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Cl1(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}