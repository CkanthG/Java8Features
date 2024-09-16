package classes.java8;

import java.util.function.Function;

public class FunctionInterfaceImpl {
    public static void main(String[] args) {
        Function<Integer, String> function = (t) -> "output : "+t;
        System.out.println(function.apply(100));
    }
}
