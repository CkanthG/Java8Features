package classes.java8;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,2,4,5,6,21,7,8,9);
        list.stream().filter(i -> i > 4)
                .sorted()
                .forEach(new StreamExample()::printElements);
    }
    public void printElements(int i) {
        System.out.println("List Element :" + i);
    }
}
