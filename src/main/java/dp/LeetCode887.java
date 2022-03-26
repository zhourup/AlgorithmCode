package main.java.dp;

/**
 * @author zhourup
 * @date 2022/3/25 20:43
 */
public class LeetCode887 {

    public static void main(String[] args) {
        int k = 2;
        int n = 6;
        System.out.println(superEggDrop1(k, n));

    }

    static int[][] memo;

    /**
     * 表示为求dp(k,n),K为鸡蛋数，n为楼层数
     * 当我们在x楼扔时有两种情况：
     * 1、鸡蛋不碎，状态就变成了(k,n-x)答案只可能在上面的n-x层楼
     * 2、鸡蛋碎了，状态就变成了(k-1,x-1)答案只可能在第x楼下面的x-1层楼中
     * 所以dp(k,n)=1+min(max(dp(k-1,x-1),dp(k,n-x))+1)
     *
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        return dp(k, n);
    }

    private static int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[k][n] != 0) {
            return memo[k][n];
        }

        int result = n;
        int left = 1;
        int right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int left_result = dp(k - 1, mid - 1);
            int right_result = dp(k, n - mid);
            result = Math.min(Math.max(left_result, right_result) + 1, result);
            if (left_result < right_result) {
                left = mid + 1;
            } else if (left_result > right_result) {
                right = mid;
            } else {
                break;
            }
        }
        memo[k][n] = result;
        return memo[k][n];
    }


    private static int superEggDrop1(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 0; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
