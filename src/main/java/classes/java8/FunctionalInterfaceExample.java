package classes.java8;

import static java.lang.System.*;

public class FunctionalInterfaceExample implements CustomFunctionalInterface{
    public static void main(String[] args) {
        new FunctionalInterfaceExample().callRunnableInterface();
        out.println(new FunctionalInterfaceExample().doCustomImplementation("This is my custom functional interface"));
        new FunctionalInterfaceExample().callCustomFunctionalInterface();
    }

    public void callCustomFunctionalInterface() {
        CustomFunctionalInterface customFunctionalInterface = (input) -> "Give me some input so that i can run";
        out.println(customFunctionalInterface.doCustomImplementation("Hey Start Run"));
    }

    public void callRunnableInterface() {
        Runnable run = () -> out.println("Runnable Interface used for creating the Thread");
        new Thread(run).start();
    }

    @Override
    public String doCustomImplementation(String input) {
        return "Given Input is :"+input;
    }
}
