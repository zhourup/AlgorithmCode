package main.java.dp;

public class LeetCode931 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9},
        };
        System.out.println(minFallingPathSum(matrix));
    }

    /**
     * 法一、动态规划
     *
     * @param matrix
     * @return
     */
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //dp[i]表示到到i层的最小和
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int min;
                if (j == 1) {
                    min = n == 1 ? dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n) {
                    min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
                dp[i][j] = min + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[m][i]);
        }
        return res;
    }
}
