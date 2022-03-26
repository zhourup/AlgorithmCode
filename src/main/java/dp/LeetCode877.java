package main.java.dp;

/**
 * @author zhourup
 * @date 2022/3/26 21:58
 */
public class LeetCode877 {

    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 3};
        System.out.println(stoneGame(nums));
    }

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int p : piles) {
            sum += p;
        }
        //dp[i][j]=x表示Alice能在[i,j]之间获得最多的石子为x。结果为dp[0][n-1]
        // dp[i][j]=Math.max(dp[i+1][j]+piles[i],dp[i][j-1]+piles[j])
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i + 1][j] + piles[i], dp[i][j - 1] + piles[j]);
            }
        }
        int bob = sum - dp[0][n - 1];
        return dp[0][n - 1] > bob;
    }
}
