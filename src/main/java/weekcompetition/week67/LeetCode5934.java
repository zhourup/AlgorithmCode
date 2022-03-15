package main.java.weekcompetition.week67;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/12/11 22:30
 */
public class LeetCode5934 {

    public static void main(String[] args) {
        int[] nums = new int[]{50, -75};
        int k = 2;
        int[] res = maxSubsequence1(nums, k);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 法二
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        int[] newArray = Arrays.copyOf(nums, nums.length);

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (map.containsKey(newArray[i]) && map.get(newArray[i]) > 0) {
                res[index++] = newArray[i];
                map.put(newArray[i], map.get(newArray[i]) - 1);
            }
            if (index == k) {
                break;
            }
        }
        return res;
    }

    /**
     * 法二、基数排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSubsequence1(int[] nums, int k) {
        int n = nums.length;
        //用来存储数组和索引
        int[][] values = new int[n][2];
        for (int i = 0; i < n; i++) {
            values[i][0] = i;
            values[i][1] = nums[i];
        }
        //将values从大到小排序
        Arrays.sort(values, (a, b) -> b[1] - a[1]);
        //将values的[0,k)区间的数按索引从小到大排序
        Arrays.sort(values, 0, k, (a, b) -> a[0] - b[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = values[i][1];
        }
        return res;
    }
}
