package classes.leetcode;

public class JumpGameII {
    public int canJump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int currentValue = 0;
        int c = 0;
        for (int i=0; i<nums.length; i++) {
            c = Math.max(c, nums[i + 1]);
            if (i == currentValue) {
                jumps ++;
                currentValue = c;
                if (c >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().canJump(new int[]{2,3,1,1,4}));
    }
}
