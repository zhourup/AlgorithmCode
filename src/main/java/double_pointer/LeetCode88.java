package main.java.double_pointer;

/**
 * 88 合并两个有序数组
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    /**
     * 双指针法，从后往前
     *
     * @param nums1 数组1
     * @param m     数组1的的元素数量
     * @param nums2 数组2
     * @param n     数组2的元素数量
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        for (int i = 0; i < nums1.length; i++)
            System.out.println(nums1[i]);
    }
}
