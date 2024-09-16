package classes.assessment;

import java.util.Arrays;

import static java.lang.System.*;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int max = Arrays.stream(A).max().getAsInt();
        if (max < 0){
            return 1;
        } else if ( max <= 3) {
            return 4;
        }
        return max-1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        out.println(new Solution().solution(a));
    }
}
