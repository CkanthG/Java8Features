package classes.designpatterns.creational.builder;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        // Creating a computer with required and optional parameters
        Computer computer = new Computer.ComputerBuilder("500 GB", "16 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
        System.out.println(computer);
        // Creating a computer with only required parameters
        Computer basicComputer = new Computer.ComputerBuilder("250 GB", "8 GB")
                .build();
        System.out.println(basicComputer);
    }
}
