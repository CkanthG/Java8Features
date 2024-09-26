package classes.designpatterns.creational.factory;

public class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("Woof! Woof!");
    }
}
