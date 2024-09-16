package classes.java8.exceptions;

import static java.lang.System.*;

public class B1 extends A1 {

    public B1() throws Exception {

        out.println("B1 Constructor");
        super.display();
    }

    public void display() throws Exception {
        out.println("abcd");
        super.display();
        throw new Exception("exception");
    }
}
