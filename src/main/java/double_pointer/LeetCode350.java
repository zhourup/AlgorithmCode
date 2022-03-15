package main.java.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode350 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersect(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 双指针法
     * 1、先对两个数组排序
     * 2、建立f1,f2指针，分别指向nums1数组，nums2数组的下标
     * 3、若nums1[f1]>nums[f2]，则指针f2移动一位；若num1[f1]<nums[f2]，则指针f1移动一位；若相等，便是找到了两个数组的交集之一，加入动态数组array中
     * 4、重复步骤3，直到其中一个数组迭代完，便退出循环
     * 5、将动态数组array赋值给静态数组result,并返回result
     * @param nums1 数组1
     * @param nums2 数组2
     * @return result
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int f1 = 0, f2 = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (f1 < nums1.length && f2 < nums2.length) {
            if (nums1[f1] < nums2[f2]) {
                f1++;
            } else if (nums1[f1] > nums2[f2]) {
                f2++;
            } else {
                array.add(nums1[f1]);
                f1++;
                f2++;
            }
        }
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;
    }
}
