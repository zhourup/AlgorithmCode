package main.java.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhourup
 * @date 2021/12/6 13:20
 */
public class LeetCode3 {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring1(s));
    }


    /**
     * 法一
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            }
            //一直删除到和right一样的字符
            while (right < s.length() && set.contains(s.charAt(right))) {
                char c = s.charAt(left++);
                set.remove(c);
            }
        }
        return max;
    }

    /**
     * 法二
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char l = s.charAt(left++);
                window.put(l, window.get(l) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
