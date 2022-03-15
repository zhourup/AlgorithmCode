package main.java.hot100;

import java.util.Arrays;

/**
 * @author zhourup
 * 4. 寻找两个正序数组的中位数
 */
public class Hot4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays3(nums1, nums2));

    }

    /**
     * 法一、合并数组并排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[nums1.length + i] = nums2[i];
        }
        Arrays.sort(nums);
        if (len % 2 == 0) {
            double temp = nums[len / 2] + nums[len / 2 - 1];
            return temp / 2;
        } else {
            return nums[len / 2];
        }
    }

    /**
     * 法二、双指针遍历数组，从最小寻找中间的数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = len / 2 + 1;
        int[] num = new int[k];
        int count = 0;
        int point1 = 0;
        int point2 = 0;
        while (point1 < nums1.length && point2 < nums2.length && count < k) {
            if (nums1[point1] < nums2[point2]) {
                num[count] = nums1[point1];
                point1++;
            } else {
                num[count] = nums2[point2];
                point2++;
            }
            count++;
        }
        while (count < k && point1 < nums1.length) {
            num[count] = nums1[point1];
            count++;
            point1++;
        }
        while (count < k && point2 < nums2.length) {
            num[count] = nums2[point2];
            count++;
            point2++;
        }

        if (len % 2 == 0) {
            double sum = num[len / 2] + num[len / 2 - 1];
            return sum / 2;
        } else {
            return num[len / 2];
        }
    }

    /**
     * 法三  O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        //保存当前循环的结果，right是当前遍历到的值，left是前一个值
        int left = -1, right = -1;
        //nums1和nums2的索引
        int point1 = 0, point2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (point1 < m && (point2 >= n || nums1[point1] < nums2[point2])) {
                right = nums1[point1++];
            } else {
                right = nums2[point2++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 法四  O(log(m+n)) 二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让len1的长度小于len2，这样就能保证如果有数组空了，一定是len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
