package classes.corejava;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;

public class FindDuplicateCharactersInString {
    public static void main(String[] args) {
        new FindDuplicateCharactersInString().findDuplicates("Welcome");
        new FindDuplicateCharactersInString().duplicateCount("Welcome");
    }
    public void duplicateCount(String str){
        String[] strings = str.split("");
        out.println(strings.length);
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.compute(string, (k, count) -> count + 1);
            } else {
                map.put(string, 1);
            }
        }
        out.println(map);
    }

    public void findDuplicates(String str) {
        char[] chars = str.toCharArray();
        out.println("Duplicate finding starts");
        for (int i=0; i<str.length();i++){
            for (int j = i+1; j<str.length(); j++) {
                if (chars[i] == chars[j]) {
                    out.println(chars[j]);
                    break;
                }
            }
        }
    }
}
