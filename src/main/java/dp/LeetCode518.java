package main.java.dp;

public class LeetCode518 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change1(amount, coins));

    }

    /**
     * 题目可理解为：背包容量为amount，有len(coins)个物品，每个物品的重量为coins[i]，每个物品有无限个，请问有多少种装法刚好装满背包
     *
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        int N = coins.length, W = amount;
        //dp[i][j]=x表示为：前i个物品，容量为j，有x种方式装满背包 base case:dp[.][0]=1  背包容量为0，则装满
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (j - coins[i - 1] < 0) {
                    //装不下物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装得下,装和不装
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 动态规划+空间压缩
     *
     * @param amount
     * @param coins
     * @return
     */
    public static int change1(int amount, int[] coins) {
        int w = amount;
        int[] dp = new int[w + 1];
        //容量为0时只有一种装法
        dp[0] = 1;
        //物品
        for (int i = 0; i < coins.length; i++) {
            //容量
            for (int j = 1; j <= w; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[w];
    }
}
