package classes.designpatterns.structural.decorator;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("Basic Car Assembled Here!");
    }
}
