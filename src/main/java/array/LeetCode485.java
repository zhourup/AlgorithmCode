package main.java.array;

public class LeetCode485 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 法一：常规遍历数组
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    /**
     * 法二：滑动窗口
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int maxSize = 0;
        while (right < len) {
            if (nums[right++] == 0) {
                maxSize = Math.max(maxSize, right - left - 1);
                left = right;
            }
        }
        return Math.max(maxSize, right - left);
    }
}
