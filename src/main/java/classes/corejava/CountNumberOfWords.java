package classes.corejava;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class CountNumberOfWords {

    public Map<String, Integer> countWords(String str) {
        String[] strings = str.split(" ");
        Map<String, Integer> countMap = new HashMap<>();
        for (String string : strings) {
            if (countMap.containsKey(string)) {
                countMap.compute(string, (k, count) -> count + 1);
            } else {
                countMap.put(string, 1);
            }
        }
        return countMap;
    }
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new CountNumberOfWords().countWords("Hello World world is groung too fast is not?");
        out.println(stringIntegerMap);
    }
}
