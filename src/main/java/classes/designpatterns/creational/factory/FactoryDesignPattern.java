package classes.designpatterns.creational.factory;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.createAnimal("Dog");
        dog.speak();

        Animal cat = animalFactory.createAnimal("cat");
        cat.speak();
    }
}
