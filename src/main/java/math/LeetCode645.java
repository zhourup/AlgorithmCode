package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/15 12:31
 */
public class LeetCode645 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int[] res = findErrorNums(nums);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    /**
     * 时间O(N)，空间O(1)
     * 思路：通过将每个索引对应的元素变成负数，以表示这个索引被对应过一次了
     *
     * @param nums
     * @return res[0]重复出现的数字，res[1]缺失的数字
     */
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        // 记录重复的数
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                dup = index + 1;
            }
        }
        int miss = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        return new int[]{dup, miss};
    }
}
