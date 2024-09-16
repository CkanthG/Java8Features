package classes.java8.exceptions;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.*;

public class C1 extends B1 {

    public C1() throws Exception {
        super();
    }

    public void display() {
        String s1 = "I am a programmer";
        String s2 = "programmer a am I";
        long l = Arrays.stream(s1.split("")).count();
        out.println("l : " + l);
        Stream<String> sorted1 = Arrays.stream(s1.split("")).sorted();
        out.println();
        Stream<String> sorted2 = Arrays.stream(s2.split("")).sorted();
        out.println();
        out.println("Equals or not : "+ (sorted1.toList().equals(sorted2.toList())));
        throw new ArithmeticException("arithmetic exception");
    }

    public static void main(String[] args) throws Exception {
        A1 c = new C1();
        try {
            c.display();
        }catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}