package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/18 10:26
 */
public class Hot198 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob2(nums));

    }

    /**
     * 法一、动态规划 时间和空间都是O(N)
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        //偷窃前n间房的最高金额=偷窃前n-1间房最大的金额或前n-2间房的金额+第n间房的金额
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 法二、动态规划+空间压缩
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int max = 0;
        int preTwo = 0;
        int preOne = nums[0];
        for (int i = 2; i <= len; i++) {
            max = Math.max(preOne, preTwo + nums[i - 1]);
            preTwo = preOne;
            preOne = max;
        }
        return max;
    }

    /**
     * 法三、动态规划另外写法
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = nums[i];
                continue;
            }
            //在i位置不抢
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //在i位置抢
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
