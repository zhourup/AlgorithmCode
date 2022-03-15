package main.java.dp;

public class LeetCode1143 {

    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "ace";
        System.out.println(longestCommonSubsequence(word1, word2));
    }

    /**
     * 返回两个字符串的最长公共子序列的长度
     * abcde 和 ach 的最长公共子序列长度为 2
     * LCS
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //dp[i][j]表示为s1[0...i-1]和s2[0...j-1]的lcs长度，base case：dp[0][j]=dp[i][j]=0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
