package main.java.greedy;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/4/2 16:17
 */
public class LeetCode45II {

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    /**
     * 法一、动态规划
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        //dp[i]表示到i位置所需要的最少跳跃次数
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 法二、贪心
     *
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
