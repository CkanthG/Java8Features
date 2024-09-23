package classes.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class JavaStreamOperations {
    public static void main(String[] args) {
        List<Employee> employeeList = employeesList();
        // 1. get employee names as a list
        List<String> namesList = employeeList.stream().map(emp -> emp.getName()).toList();
        out.println("namesList : " + namesList);
        namesList = employeeList.stream().map(Employee::getName).toList();
        out.println("namesList : " + namesList);
        // 2. Employee Names , Age > 25
        List<String> namesAgeAbove25 = employeeList.stream().filter(e -> e.getAge() > 25).map(e -> e.getName()).toList();
        out.println("namesAgeAbove25 :" + namesAgeAbove25);
        namesAgeAbove25 = employeeList.stream().filter(e -> e.getAge() > 25).map(Employee::getName).toList();
        out.println("namesAgeAbove25 :" + namesAgeAbove25);
        // 3. Print all distinct city names of employees
        List<String> cityNamesList = employeeList.stream().map(Employee::getCity).distinct().toList();
        out.println("cityNamesList :" + cityNamesList);
        // 4. Get Count of employees whose salary is > 20K
        long countOfEmployees = employeeList.stream().filter(e -> e.getSalary() > 20000).count();
        out.println("countOfEmployees : " + countOfEmployees);
        // 5. Get first 3 employee objects as a list
        List<Employee> first3Employees = employeeList.stream().limit(3).toList();
        out.println("first3Employees : " + first3Employees);
        // 6. skip first 3 employees and I want to collect others employees Data
        List<Employee> skipFirst3Employees = employeeList.stream().skip(3).toList();
        out.println("skipFirst3Employees : " +skipFirst3Employees);
        // 7. Verify any emp < 28
        boolean age28OrBelow = employeeList.stream().anyMatch(e -> e.getAge() < 28);
        out.println("age28OrBelow : " + age28OrBelow);
        // 8. Check very employee joined after 2008 or not.
        boolean joinYearAfter2010 = employeeList.stream().allMatch(e -> e.getYearOfJoining() > 2008);
        out.println("joinYearAfter2010 : " + joinYearAfter2010);
        // 9. every employee salary under < 9000
        boolean employeeSalaryUnder9000 = employeeList.stream().noneMatch(e -> e.getSalary() < 9000);
        out.println("employeeSalaryUnder9000 : " + employeeSalaryUnder9000);
        // 10. get One value from out of all values
        Optional<Employee> anyEmployeeFromList = employeeList.stream().findAny();
        out.println("anyEmployeeFromList : " + anyEmployeeFromList.get());
        // 11. It will always return first element of the Stream
        Optional<Employee> firstEmployee = employeeList.stream().findFirst();
        out.println("firstEmployee : " + firstEmployee.get());
        // 12. Get Employee Id's in sorted Order
        List<Integer> employeeIdsInSortedOrder = employeeList.stream().map(Employee::getId).sorted().toList();
        out.println("employeeIdsInSortedOrder : " + employeeIdsInSortedOrder);
        // 13. Define Sorting based on employee Id's, Sort Employee Objects
        List<Employee> employeeObjectsInSortedOrder = employeeList.stream().sorted((e1, e2) -> e1.getId() - e2.getId()).toList();
        out.println("employeeObjectsInSortedOrder ASC : " + employeeObjectsInSortedOrder);
        employeeObjectsInSortedOrder = employeeList.stream().sorted(Comparator.comparing(Employee::getId)).toList();
        out.println("Using Comparator.comparing -> employeeObjectsInSortedOrder ASC : " + employeeObjectsInSortedOrder);
        employeeObjectsInSortedOrder = employeeList.stream().sorted((e1, e2) -> e2.getId() - e1.getId()).toList();
        out.println("employeeObjectsInSortedOrder DESC : " + employeeObjectsInSortedOrder);
        // 14. minimum salary employee details
        Optional<Employee> minSalaryEmployeeObject = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
        out.println("minSalaryEmployeeObject : " + minSalaryEmployeeObject.get());
        // 15. Maximum salary Employee Details
        Optional<Employee> maxSalaryEmployeeObject = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        out.println("maxSalaryEmployeeObject : " + maxSalaryEmployeeObject.get());
        // 16. average salary of employees
        OptionalDouble averageSalaryOfEmployee = employeeList.stream().mapToDouble(Employee::getSalary).average();
        out.println("averageSalaryOfEmployee : " + averageSalaryOfEmployee.getAsDouble());
        // 17. avg age of emp
        OptionalDouble averageAgeOfEmployee = employeeList.stream().mapToInt(Employee::getAge).average();
        out.println("averageAgeOfEmployee : " + averageAgeOfEmployee.getAsDouble());
        // 18. Out of all employees, find whose date of joining > 2015, Track How many Employees are processed.
        List<Employee> employeesDateOfJoiningAbove2015UsingFilterAndPeek = employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015).peek(out::println).toList();
        out.println("employeesDateOfJoiningAbove2015UsingFilterAndPeek : " + employeesDateOfJoiningAbove2015UsingFilterAndPeek);
        // 19. Collect All Employee Names as a List, whose age is greater than 25
        List<String> collectEmployeeNamesWhereAgeGreaterThan25 = employeeList.stream()
                .filter(e -> e.getAge() > 25).map(Employee::getName).collect(Collectors.toList());
        out.println("collectEmployeeNamesWhereAgeGreaterThan25 : " + collectEmployeeNamesWhereAgeGreaterThan25);
        // 20. collect employee IDs and their salaries as Map
        Map<Integer, Double> collectEmployeeIdAndEmployeeSalaryMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getSalary));
        out.println("collectEmployeeIdAndEmployeeSalaryMap : " + collectEmployeeIdAndEmployeeSalaryMap);
        // 21. get avg salary of each department
        Map<String, Double> collectAvgSalaryEachDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        out.println("collectAvgSalaryEachDepartment : " + collectAvgSalaryEachDepartment);
        // 22. Get Count of employees gender wise
        Map<String, Long> collectGenderWiseEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        out.println("collectGenderWiseEmployees : " + collectGenderWiseEmployees);
        // 23. Summing All employees salaries -> summing.., summarizing...
        Double summarizeAllSalaries = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        out.println("summarizeAllSalaries : " + summarizeAllSalaries);
        summarizeAllSalaries = employeeList.stream().mapToDouble(Employee::getSalary).sum();
        out.println("summarizeAllSalaries using mapToDouble and sum : " + summarizeAllSalaries);
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        out.println("doubleSummaryStatistics : " + doubleSummaryStatistics);
        // 24. finding max age of employees
        Optional<Employee> maxByAgeEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
        out.println("maxByAgeEmployee : " + maxByAgeEmployee.get());
        Optional<Employee> maxAgeEmployee = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        out.println("maxAgeEmployee using max: " + maxAgeEmployee.get());
        // 25. All Department names with delimiter :::
        String collectAllDepartmentsWithDelimiter = employeeList.stream()
                .map(Employee::getDepartment).collect(Collectors.joining(":::"));
        out.println("collectAllDepartmentsWithDelimiter : " + collectAllDepartmentsWithDelimiter);
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
