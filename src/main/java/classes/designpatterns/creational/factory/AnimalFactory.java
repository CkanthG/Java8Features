package classes.designpatterns.creational.factory;

// Factory Class
public class AnimalFactory {

    // Factory method to create Animal objects
    public Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("Cat")) {
            return new Cat();
        }
        return null;
    }
}
