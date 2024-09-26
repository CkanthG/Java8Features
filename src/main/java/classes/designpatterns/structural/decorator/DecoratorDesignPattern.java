package classes.designpatterns.structural.decorator;

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
