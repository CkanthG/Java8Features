package classes.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3749));
        System.out.println(new IntegerToRoman().intToRoman(58));
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }
}
