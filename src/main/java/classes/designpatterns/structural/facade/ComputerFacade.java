package classes.designpatterns.structural.facade;

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void start() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer Started Successfully");
    }

    public void stop() {
        memory.free();
        hardDrive.write();
        cpu.stop();
        System.out.println("Computer Shutdown Successfully");
    }
}
