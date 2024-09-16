package classes.corejava;

import static java.lang.System.*;

public class ReverseString {
    public static void main(String[] args) {
        String str = "ReverseThisString";
        ReverseString reverseStringObject = new ReverseString();
        out.println(reverseStringObject.reverseString(str));
        reverseStringObject.reverseStringValue(str);
    }

    public String reverseString(String str) {
        StringBuilder stringBuffer = new StringBuilder(str);
        return stringBuffer.reverse().toString();
    }

    public void reverseStringValue(String str) {
        out.print("Original String: "+ str + "\nAfter Reverse: ");
        String[] strArray = str.split("");
        for (int i=strArray.length-1; i>=0; i--) {
            out.print(strArray[i]);
        }
    }
}
