package classes.designpatterns.behavioral.chain.of.responsibility;

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        errorLogger.logMessage(Logger.INFO, "This is an information.");
        errorLogger.logMessage(Logger.DEBUG, "This is a debug level information.");
        errorLogger.logMessage(Logger.ERROR, "This is an error information.");
    }
}
