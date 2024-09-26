package classes.designpatterns.behavioral.chain.of.responsibility;

public class ConsoleLogger extends Logger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("Standard Console::Logger:" + message);
    }
}
