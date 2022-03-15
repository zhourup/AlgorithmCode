package main.java.dp;

public class LeetCode416 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition1(nums));
    }

    /**
     * 法一，动态规划
     * 转化为背包问题：给一个可装载sum/2的背包和N个物品，每个物品重量为nums[i]，现在是否存在一种装法，能够恰好装满背包
     * dp[i][j]=x表示为: 对于前i个物品，当背包容量为j时，若x为true则说明恰好把背包装满，若x为false则说明不能恰好将背包装满
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //和为奇数时不能分为两个和相等的集合
        if (sum % 2 != 0) {
            return false;
        }
        int N = nums.length, W = sum / 2;
        boolean[][] dp = new boolean[N + 1][W + 1];
        //base case是dp[.][0]=true和dp[0][.]=false，因为背包没有空间时相当于装满了
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - nums[i - 1] < 0) {
                    //背包容量不够，不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装入或不装入
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 法二、动态规划+空间压缩
     *
     * @param nums
     * @return
     */
    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = W; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[W];
    }
}
