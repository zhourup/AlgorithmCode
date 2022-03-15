package main.java.dp;

/**
 * @author zhourup
 * @date 2021/12/8 11:18
 */
public class LeetCode122 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit1(nums));
    }

    /**
     * 法一、动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 法二、动态规划+空间压缩
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int pre0 = 0, pre1 = 0;
        int curr0 = 0, curr1 = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                pre0 = 0;
                pre1 = -prices[i];
                continue;
            }
            curr0 = Math.max(pre0, pre1 + prices[i]);
            curr1 = Math.max(pre1, pre0 - prices[i]);
            pre0 = curr0;
            pre1 = curr1;
        }
        return curr0;
    }
}
