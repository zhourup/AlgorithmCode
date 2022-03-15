package main.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode279 {

    public static void main(String[] args) {
        System.out.println(numSquares2(13));
    }

    /**
     * 法一：动态规划
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        List<Integer> list = generateNums(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) <= i) {
                    dp[i] = Math.min(dp[i], dp[i - list.get(j)] + 1);
                }
            }
        }
        return dp[n];
    }

    public static List<Integer> generateNums(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            list.add(i * i);
            i++;
        }
        return list;
    }

    /**
     * 法二：优化的动态规划
     *
     * @param n
     * @return
     */
    public static int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 法三：拉格朗日四平方和
     *
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        if (isSquare(n)) {
            return 1;
        }
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private static boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }
}
