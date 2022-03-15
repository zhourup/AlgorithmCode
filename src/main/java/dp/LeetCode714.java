package main.java.dp;

/**
 * @author zhourup
 * @date 2021/12/8 12:28
 */
public class LeetCode714 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }

    /**
     * 法一、动态规划
     * 关于fee是在买的时候减，还是买的时候减：
     * 1、如果dp[0][1]=-price[0]-fee，则一直在dp[i][1]的时候减fee
     * 2、如果dp[0][1]=-price[0],则一直在dp[i][0]的时候减fee
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划+空间压缩
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int pre0 = 0, pre1 = -prices[0];
        int cur0 = 0, cur1 = 0;
        for (int i = 1; i < n; i++) {
            cur0 = Math.max(pre0, pre1 + prices[i] - fee);
            cur1 = Math.max(pre1, pre0 - prices[i]);
            pre0 = cur0;
            pre1 = cur1;
        }
        return cur0;
    }
}
