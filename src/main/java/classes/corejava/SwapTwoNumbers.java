package classes.corejava;

import static java.lang.System.*;

public class SwapTwoNumbers {

    public void swapTwoNumbers(int a, int b) {
        int c;
        c = a;
        a = b;
        b = c;
        out.println("a : "+a+" b : "+b);
    }

    public static void main(String[] args) {
        new SwapTwoNumbers().swapTwoNumbers(1, 3);
    }
}
