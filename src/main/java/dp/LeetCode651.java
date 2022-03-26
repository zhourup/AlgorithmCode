package main.java.dp;

/**
 * @author zhourup
 * @date 2022/3/26 22:28
 */
public class LeetCode651 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(maxA(n));
    }

    public static int maxA(int n) {
        //dp[i]=x表示在按下第i次键后最多显示x个A
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            // 全选&复制dp[j-2]
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[n];
    }
}
