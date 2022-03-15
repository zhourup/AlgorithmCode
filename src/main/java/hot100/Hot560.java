package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/11/13 11:16
 */
public class Hot560 {

    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        System.out.println(subarraySum1(nums, k));
    }


    /**
     * 法一、动态规划+空间压缩
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int curr = 0, pre = 0;
            for (int j = i; j <= n; j++) {
                curr = pre + nums[j - 1];
                if (curr == k) {
                    count++;
                }
                pre = curr;
            }
        }
        return count;
    }

    /**
     * 法二、前缀和+哈希表优化
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
