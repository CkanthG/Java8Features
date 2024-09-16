package classes.java8;

import classes.models.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsCollectingAndThen {

    public void collectingAndThen() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Sowmya", "DEV", 500000),
                new Employee(2, "Devansh", "DEV", 200000),
                new Employee(3, "Sreekanth", "QA", 300000),
                new Employee(4, "Ckanth", "QA", 100000),
                new Employee(5, "Anil", "DEVOPS", 400000)
        );

        Long collect = employeeList.stream()
                .mapToDouble(Employee::getSalary).boxed().collect(
                        Collectors.collectingAndThen(
                                Collectors.averagingDouble(Double::doubleValue),
                                Math::round
                        )
                );
        System.out.println(collect);
    }
}
