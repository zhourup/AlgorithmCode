package main.java.dp;

public class LeetCode516 {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
    }

    /**
     * dp[i][j]表示字符串s(i-j)的最长回文字符串
     * s[i]=s[j] dp[i][j]=dp[i+1][j-1]+2
     * s[i]!=s[j] dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
