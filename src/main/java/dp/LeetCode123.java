package main.java.dp;

/**
 * @author zhourup
 * @date 2021/12/8 12:26
 */
public class LeetCode123 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums));
    }

    /**
     * 法一、动态规划
     * 操作次数k的减少应该在买的时候减，如果在卖的时候减会出现交易次数超出限制的错误
     * dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prince[i]);
     * dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     * <p>
     * dp[i][k][0]表示第i天至今最多进行k次交易的最大利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
