package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/2 16:23
 */
public class Hot312 {

    public static void main(String[] args) {
        int[] nums = {1, 5};
        System.out.println(maxCoins(nums));
    }


    /**
     * 动态规划
     * dp[i][j]表示填满区间（i,j）能得到的最多硬币数
     *
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }
}
