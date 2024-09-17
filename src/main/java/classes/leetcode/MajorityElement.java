package classes.leetcode;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int maxCount = 0;
        int majorityElement = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}
