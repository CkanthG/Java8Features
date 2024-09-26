package classes.designpatterns.structural.decorator;

public class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println("Luxury Features Assembled Here!");
    }
}
