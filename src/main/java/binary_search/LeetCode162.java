package main.java.binary_search;

public class LeetCode162 {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(findPeakElement2(nums));
    }

    /**
     * 法一：线性扫描:o(N)，自己写的
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums.length == 2) {
            if (nums[0] < nums[1]) {
                return 1;
            }
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
            if (nums[i] < nums[i + 1] && (i + 1) == nums.length - 1) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * 法二：线性扫描：O(N)
     *
     * @param nums
     * @return
     */
    public static int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    /**
     * 法三，递归二分查找
     *
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    /**
     * 法四，迭代二分查找
     *
     * @param nums
     * @return
     */
    public static int findPeakElement3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
