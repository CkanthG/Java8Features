package classes.leetcode;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int l = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[l++] = nums[i];
        }
        for (int i = 0; i<nums.length - k; i++) {
            temp[l++] = nums[i];
        }
        for (int i=0,j=0;i<temp.length&&j<nums.length;i++,j++) {
            nums[j] = temp[i];
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
