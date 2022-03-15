package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/10 17:26
 */
public class Sword10II {

    public static void main(String[] args) {
        int n = 44;
        System.out.println(numWays(n));
    }

    public static int numWays(int n) {
        //dp[i]=x表示的意思为登上i级台阶总共有x中跳法
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }
}
