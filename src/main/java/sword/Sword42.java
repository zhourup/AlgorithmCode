package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/31 15:28
 */
public class Sword42 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int preSum = 0;
        int minSum = 0;
        int maxSubSum = Integer.MIN_VALUE;
        for (int num : nums) {
            preSum += num;
            maxSubSum = Math.max(maxSubSum, preSum - minSum);
            minSum = Math.min(minSum, preSum);
        }
        return maxSubSum;
    }
}
