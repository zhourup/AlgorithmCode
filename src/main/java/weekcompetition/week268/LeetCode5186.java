package main.java.weekcompetition.week268;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/11/21 11:06
 */
public class LeetCode5186 {

    static class RangeFreqQuery {
        int[] nums;
        Map<String, Integer> map;

        public RangeFreqQuery(int[] arr) {
            nums = arr;
            map = new HashMap<>();
        }

        public int query(int left, int right, int value) {
            String key = left + "-" + right + "-" + value;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int count = 0;
            for (int i = left; i <= right; i++) {
                if (nums[i] == value) {
                    count++;
                }
            }
            map.put(key, count);
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(nums);
        System.out.println(rangeFreqQuery.query(1, 2, 4));
        System.out.println(rangeFreqQuery.query(0, 11, 33));
    }


}
