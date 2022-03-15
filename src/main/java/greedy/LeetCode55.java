package main.java.greedy;

public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};
        System.out.println(canJump(nums));

    }

    /**
     * 法一：动态规划
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        boolean dp[] = new boolean[nums.length + max + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                dp[i + j] = dp[i + j] || dp[i];
            }
            dp[i + nums[i]] = dp[i];
        }
        return dp[nums.length - 1];
    }

    /**
     * 法二：维护最远可以到达的位置
     *
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
