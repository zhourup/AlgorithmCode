package main.java.dp;

/**
 * @author zhourup
 * @date 2021/12/8 21:02
 */
public class LeetCode213 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }

    /**
     * 首尾房间不能同时被抢
     * 1、首被抢，尾不抢
     * 2、首不抢、尾被抢
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    /**
     * 计算在nums在[start,end]区间可以抢劫到的最高金额
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int robRange(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[][] dp = new int[len][2];
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[i - start][0] = 0;
                dp[i - start][1] = nums[i];
                continue;
            }
            dp[i - start][0] = Math.max(dp[i - start - 1][0], dp[i - start - 1][1]);
            dp[i - start][1] = dp[i - start - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
