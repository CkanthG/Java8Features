package classes.leetcode;

import java.util.Arrays;

import static java.lang.System.*;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return new int[n];
        }
        int[] result = new int[n];
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        rightProducts[n - 1] = 1;
        for (int i = n-2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        for (int i=0; i<n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }

    public static void main(String[] args) {
        out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4})));
        out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1,1,0,-3,3})));
        out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{0,0})));
    }
}
