package main.java.dp;

/**
 * @author zhourup
 * @date 2021/12/8 15:42
 */
public class LeetCode188 {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int k = 2;
        System.out.println(maxProfit(k, nums));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
