package classes.functionalinterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.System.*;

public class Functions {

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("Johnny", s -> s.length());
        Integer value1 = nameMap.computeIfAbsent("Johnny", String::length);
        out.println(value);
        out.println(value1);
        Function<Integer, String> intToString = Object::toString;
        out.println(intToString);
        Function<String, String> quote = s -> "'" + s + "'";
        out.println(quote);
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        if("'5'".equals(quoteIntToString.apply(5))) {
            out.println("Welcome");
        }
    }

}
