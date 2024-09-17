package classes.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (set.add(num)) {
                temp[count++] = num;
            }
        }
        System.arraycopy(temp, 0, nums, 0, count);
        return count;
    }
}
