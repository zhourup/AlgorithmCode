package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/17 15:06
 */
public class Hot152 {

    public static void main(String[] args) {

        int[] nums = {-4, -3, -2};
        System.out.println(maxProduct1(nums));
    }

    /**
     * 法一、时间和空间复杂度都是O(N)
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        //maxN[i]代表以i为结尾的数组最大乘积，minN[i]代表以i为结尾的数组的最小乘积
        int[] maxN = new int[len + 1];
        int[] minN = new int[len + 1];
        maxN[0] = nums[0];
        minN[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxN[i] = Math.max(nums[i], Math.max(maxN[i - 1] * nums[i], minN[i - 1] * nums[i]));
            minN[i] = Math.min(nums[i], Math.min(minN[i - 1] * nums[i], maxN[i - 1] * nums[i]));
            res = Math.max(res, maxN[i]);
        }
        return res;
    }

    /**
     * 法二、时间O(N)，空间O(1)
     *
     * @param nums
     * @return
     */
    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int maxN = nums[0], minN = nums[0];
        for (int i = 1; i < len; i++) {
            int max = maxN, min = minN;
            maxN = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            minN = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            res = Math.max(res, maxN);
        }
        return res;
    }

}
