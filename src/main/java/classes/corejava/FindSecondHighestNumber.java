package classes.corejava;

import static java.lang.System.*;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        new FindSecondHighestNumber().findSecondHighest();
    }
    public void findSecondHighest() {
        int largest = 0, secondLargest = 0;
        int[] arr = new int[] {1,2,3,10,4,8,9,100};
        for (int j : arr) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j > secondLargest) {
                secondLargest = j;
            }
        }
        out.println("Largest Number is :"+largest + "\nSecond Largest Number is :"+ secondLargest);
    }
}
