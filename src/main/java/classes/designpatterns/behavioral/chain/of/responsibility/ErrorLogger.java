package classes.designpatterns.behavioral.chain.of.responsibility;

public class ErrorLogger extends Logger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("Error Console::Logger:" + message);
    }
}
