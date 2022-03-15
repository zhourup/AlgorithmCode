package main.java.temp.session9;

/**
 * 测试次数,用动态规划解
 */
public class topic4 {

    public static void main(String[] args) {
        int[][] dp = new int[1001][4];
        for (int n = 1; n <= 3; n++) { //手机数
            for (int i = 1; i <= 1000; i++) { //楼层数
                dp[i][n] = dp[i - 1][n] + 1;
                for (int j = 1; j < i && n > 1; j++) { //开始测试的层数，选最优解
                    dp[i][n] = Math.min(dp[i][n], Math.max(dp[j - 1][n - 1], dp[i - j][n]) + 1);
                }
            }
        }
        System.out.println(dp[1000][3]);
    }
}
