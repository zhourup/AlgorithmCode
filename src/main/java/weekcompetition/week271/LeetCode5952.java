package main.java.weekcompetition.week271;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/12 10:30
 */
public class LeetCode5952 {

    public static void main(String[] args) {
        String s = "B0B6G0R6R0R6G9";
        System.out.println(countPoints1(s));
    }

    /**
     * 法二、位运算  |  两个数都为0时，结果为0，有1即为1，如 1|1=1  1|0=1
     *
     * @param rings
     * @return
     */
    public static int countPoints1(String rings) {
        char[] arr = rings.toCharArray();
        int n = arr.length;
        if (n < 6) {
            return 0;
        }
        // nums表示10个杆的状态
        int[] nums = new int[10];
        for (int i = 0; i < n - 1; i = i + 2) {
            if (arr[i] == 'R') {
                nums[arr[i + 1] - '0'] |= 1;
            } else if (arr[i] == 'G') {
                nums[arr[i + 1] - '0'] |= 2;
            } else if (arr[i] == 'B') {
                nums[arr[i + 1] - '0'] |= 4;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == 7) {
                count++;
            }
        }
        return count;
    }

    /**
     * 法一、使用哈希表
     *
     * @param rings
     * @return
     */
    public static int countPoints(String rings) {
        int n = rings.length();
        List<Map<Character, Integer>> mapList = new ArrayList<>();
        int[] valid = new int[10];
        for (int i = 0; i < 10; i++) {
            Map<Character, Integer> map = new HashMap<>();
            mapList.add(map);
        }
        for (int i = 0; i < n - 1; i = i + 2) {
            char c = rings.charAt(i);
            int g = rings.charAt(i + 1) - '0';
            if (valid[g] == 3) {
                continue;
            }
            if (!mapList.get(g).containsKey(c)) {
                valid[g]++;
            }
            mapList.get(g).put(c, mapList.get(g).getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (valid[i] == 3) {
                count++;
            }
        }
        return count;
    }
}
