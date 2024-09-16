package classes.corejava;

public class PalindromeOrNot {

    public void isPalindrome(String str) {
        String[] strArray = str.split("");
        StringBuilder str3 = new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            str3.append(strArray[i]);
        }
        if (str.contentEquals(str3)) {
            System.out.println("The given word \""+str+"\" is a palindrome");
        } else {
            System.out.println("The given word \""+str+"\" is not a palindrome");
        }
    }

    public static void main(String[] args) {
        new PalindromeOrNot().isPalindrome("1213563121");
    }
}
