package main.java.stack;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode496 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    /**
     * 暴力法
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return result
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length && nums2[j] != nums1[i]) j++;
            if (j + 1 >= nums2.length) {
                result[i] = -1;
            } else {
                int a;
                for (a = j + 1; a < nums2.length; a++) {
                    if (nums2[a] > nums1[i]) {
                        result[i] = nums2[a];
                        break;
                    }
                }
                if (a == nums2.length && nums2[a - 1] < nums1[i])
                    result[i] = -1;
            }
        }
        return result;
    }

    /**
     * 动态规划
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return result
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) return new int[0];
        int[] next1 = new int[len1];
        int[] next2 = new int[len2];
        next2[len2 - 1] = -1;
        for (int i = len2 - 2; i >= 0; i--) {
            if (nums2[i] < nums2[i + 1]) next2[i] = i + 1;
        }
        return new int[]{};
    }

    /**
     * 单调栈
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return result
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
