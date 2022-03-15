package main.java.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * @date 2021/12/6 11:05
 */
public class LeetCode567 {

    public static void main(String[] args) {
        String s = "ab";
        String t = "eidboaoo";
        System.out.println(checkInclusion(s, t));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (map.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (map.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (valid == map.size()) {
                if (right - left == s1.length()) {
                    return true;
                }
                char l = s2.charAt(left++);
                if (map.containsKey(l)) {
                    if (map.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return false;
    }

}
