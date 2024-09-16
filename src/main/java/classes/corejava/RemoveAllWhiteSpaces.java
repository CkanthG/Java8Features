package classes.corejava;

import static java.lang.System.*;

public class RemoveAllWhiteSpaces {
    public static void main(String[] args) {
        new RemoveAllWhiteSpaces().removeWhiteSpaces("abc   sbcd sdsd");
        new RemoveAllWhiteSpaces().removeWhiteSpacesWithoutUsingReplace("abc   sbcd sdsd");
    }
    public void removeWhiteSpacesWithoutUsingReplace(String string) {
        String[] strings = string.split(" ");
        for (String s: strings) {
            out.print(s);
        }
    }
    public void removeWhiteSpaces(String str) {
        String string = str.replaceAll("\\s", "");
        out.println(string);
    }
}
