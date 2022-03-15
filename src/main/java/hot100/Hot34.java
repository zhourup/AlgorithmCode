package main.java.hot100;

public class Hot34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange1(nums, target);
        System.out.println(res[0] + " " + res[1]);

    }

    /**
     * 法一、一次二分查找后，向两边拓展寻找边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int index = binarySearch(nums, target);
        if (index != -1) {
            int[] res = expandIndex(nums, index);
            return res;
        } else {
            return new int[]{-1, -1};
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int[] expandIndex(int[] nums, int index) {
        int left = index, right = index;
        while (left - 1 >= 0 && nums[left] == nums[left - 1]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
            right++;
        }
        return new int[]{left, right};
    }


    /**
     * 法二、两次二分
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch1(nums, target, true);
        int rightIdx = binarySearch1(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private static int binarySearch1(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
