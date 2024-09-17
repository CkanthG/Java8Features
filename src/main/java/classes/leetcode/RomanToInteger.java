package classes.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int previousValue = 0;
        String[] str = s.split("");
        int total = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            int currentValue = map.get(str[i]);
            if (currentValue < previousValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            previousValue = currentValue;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("IV"));
        System.out.println(new RomanToInteger().romanToInt("LVIII"));
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
