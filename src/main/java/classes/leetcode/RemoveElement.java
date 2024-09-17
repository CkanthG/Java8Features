package classes.leetcode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int count = 0;
        for (int i=0, k=0; i<nums.length; i++) {
            if (nums[i] != val) {
                count ++;
                temp[k++] = nums[i];
            }
        }
        for (int i=0,j=0; i<temp.length && j<nums.length; i++,j++) {
            nums[j] = temp[i];
        }
        return count;
    }
}
