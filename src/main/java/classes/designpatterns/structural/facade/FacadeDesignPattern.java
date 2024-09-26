package classes.designpatterns.structural.facade;

public class FacadeDesignPattern {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade(
                new CPU(),
                new Memory(),
                new HardDrive()
        );
        computerFacade.start();
        computerFacade.stop();
    }
}
