package main.java.divide_conquer;

public class LeetCode53 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(maxSubArray4(nums));
    }

    /**
     * 法一：暴力，O(N^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * 法二：贪心，O(N)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum = curSum + nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    /**
     * 法三：动态规划 O(N)
     * 当前一个元素大于0，则将其加到当前元素上
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        return maxNum;
    }

    /**
     * 法四：动态规划O(N)
     * dp[i]：以nums[i]为结尾的最大数组和  dp[i]=Math.max(nums[i],nums[i]+dp[i-1])
     *
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        for (int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }

    /**
     * 法五：法四动态规划+空间压缩O(N)
     * dp[i]：以nums[i]为结尾的最大数组和  dp[i]=Math.max(nums[i],nums[i]+dp[i-1])
     */
    public static int maxSubArray4(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int preSum = 0;
        for (int num : nums) {
            int currSum = Math.max(num, num + preSum);
            maxSum = Math.max(maxSum, currSum);
            preSum = currSum;
        }
        return maxSum;
    }
}
