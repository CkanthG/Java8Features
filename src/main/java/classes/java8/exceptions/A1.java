package classes.java8.exceptions;

import static java.lang.System.*;

public class A1 {

    public void display() throws Exception {
        out.println("Hello");
        throw new NullPointerException("null pointer");
    }
}



