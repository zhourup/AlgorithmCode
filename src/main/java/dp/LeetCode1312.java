package main.java.dp;

/**
 * @author zhourup
 * @date 2022/3/26 23:04
 */
public class LeetCode1312 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }

    /**
     * 动态规划
     * 状态转移方程：
     * s[i]==s[j]:  dp[i][j]=dp[i+1][j-1]
     * s[i]!=s[j]   dp[i][j]=1+Math.min(dp[i+1][j],dp[i][j-1])
     *
     * @param s
     * @return
     */
    public static int minInsertions(String s) {
        int n = s.length();
        //dp[i][j]=x表示[i,j]范围成为回文数的最少操作数
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
