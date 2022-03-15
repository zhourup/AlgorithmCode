package main.java.dp;

public class LeetCode712 {

    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        //dp[i][j]表示为：字符串s1[0...i-1]和s2[0...j-1]变成LCS所需要删除的最小字符串和
        int[][] dp = new int[m + 1][n + 1];
        int sum1 = 0, sum2 = 0;
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            sum1 += s1.charAt(i - 1);
            dp[i][0] = sum1;
        }
        for (int i = 1; i <= n; i++) {
            sum2 += s2.charAt(i - 1);
            dp[0][i] = sum2;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //不用删除
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //s1[i]和s2[j]至少有一个不在lcs，删除一个
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
