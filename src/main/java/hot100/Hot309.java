package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/1 21:37
 */
public class Hot309 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit1(prices));
    }

    /**
     * 法一、动态规划
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        // dp[i][0]持有一只股票的最大利润
        // dp[i][1]今天卖掉股票后，即没有持股票了的最大利润，今天之后处于冷冻期
        // dp[i][2]未持有股票，不处于冷冻期的最大利润
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    /**
     * 法二、动态规划+空间优化
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int val0 = -prices[0], val1 = 0, val2 = 0;
        for (int i = 1; i < n; i++) {
            int temp0 = Math.max(val0, val2 - prices[i]);
            int temp1 = val0 + prices[i];
            int temp2 = Math.max(val2, val1);
            val0 = temp0;
            val1 = temp1;
            val2 = temp2;
        }
        return Math.max(val1, val2);
    }

}
