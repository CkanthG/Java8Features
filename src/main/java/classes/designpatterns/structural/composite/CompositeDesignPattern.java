package classes.designpatterns.structural.composite;

public class CompositeDesignPattern {
    public static void main(String[] args) {
        Developer dev1 = new Developer(100, "John", "Developer");
        Developer dev2 = new Developer(101, "Jane", "Developer");

        Manager man1 = new Manager(200, "Tom", "Manager");
        Manager man2 = new Manager(201, "Jerry", "Manager");

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(dev1);
        directory.addEmployee(dev2);
        directory.addEmployee(man1);
        directory.addEmployee(man2);

        directory.showEmployeeDetails();
    }

}
