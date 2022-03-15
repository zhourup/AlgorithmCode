package main.java.double_pointer;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        for (int i : result)
            System.out.println(i);

    }

    /**
     * 两个Set
     * contain操作的时间复杂度为O(1),这种方法的时间复杂度为O(n+m)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return result
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        if (set1.size() < set2.size()) return find_intersection(set1, set2);
        else return find_intersection(set2, set1);
    }

    public static int[] find_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] result = new int[set1.size()];
        int count = 0;
        for (Integer n : set1) {
            if (set2.contains(n)) result[count++] = n;
        }
        return Arrays.copyOf(result, count);
    }
}
