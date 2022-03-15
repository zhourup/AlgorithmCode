package main.java.binary_search;

public class LeetCode704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 12));
    }

    public static int search(int[] nums, int target) {
        int res = -1;
        int mid = nums.length / 2;
        if (nums[mid] == target) {
            res = mid;
        } else if (nums[mid] > target) {
            res = binarySearch(nums, 0, mid - 1, target);
        } else {
            res = binarySearch(nums, mid + 1, nums.length - 1, target);
        }
        return res;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        int res = -1;
        if (nums[mid] == target) {
            res = mid;
        } else if (nums[mid] > target && left <= mid - 1) {
            res = binarySearch(nums, left, mid - 1, target);
        } else if (nums[mid] < target && mid + 1 <= right) {
            res = binarySearch(nums, mid + 1, right, target);
        }
        return res;
    }

    /**
     * 标准答案
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int pivot = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }
}
