package main.java.hot100;

public class Hot31 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);

    }

    /**
     * 1、从右往左找到第一个非降序的数a
     * 2、再从右开始往左找到第一个比a大的数
     * 3、交换a和b
     * 4、此时b在前a在后，将b后的一段数按升序排列(由于这段数是降序的，只需从两边向中间交换位置就行)
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
