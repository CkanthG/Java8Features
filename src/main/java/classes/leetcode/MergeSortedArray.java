package classes.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int k = 0;
        for (int j : nums1) {
            if (j != 0) {
                arr[k++] = j;
            }
        }
        for (int j : nums2) {
            if (j != 0) {
                arr[k++] = j;
            }
        }
        Arrays.sort(arr);
        System.arraycopy(arr, 0, nums1, 0, arr.length);
    }
}
