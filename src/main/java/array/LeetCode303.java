package main.java.array;

/**
 * @author zhourup
 * @date 2022/1/1 23:30
 */
public class LeetCode303 {

    static class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            int n = nums.length;
            sum = new int[n + 1];
            //sum[i]表示i之前所有元素之和
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


}
