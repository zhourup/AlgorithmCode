package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot76 {

    static Map<Character, Integer> sMap = new HashMap<>();
    static Map<Character, Integer> tMap = new HashMap<>();
    static int left = 0;
    static int right = 0;
    static int len = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(minWindow(s, t));
    }

    /**
     * 给定字符串S和字符串T,请在字符串S中找出包含T所有字符的最小子串
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            //上面右指针一直往右移动，直到窗口包含t的全部字符
            while (check() && l <= r) {
                //进到此处说明窗口已经包含了t的全部字符，现在就是要将左指针右移以收缩窗口，记录满足条件的最小窗口
                if (r - l + 1 < len) {
                    left = l;
                    right = r;
                    len = r - l + 1;
                }
                if (tMap.containsKey(s.charAt(l))) {
                    sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                //需要将左移的字符从sMap去掉
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }

    /**
     * 法二、滑动窗口
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int minL = 0, minR = 0, minLen = s.length();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            //往窗口添加元素
            char c = s.charAt(right++);
            if (tMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (tMap.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //再判断窗口是否需要收缩,tMap的元素全部在window中则收缩
            while (valid == tMap.size()) {
                if (right - left <= minLen) {
                    minLen = right - left;
                    minL = left;
                    minR = right;
                }
                char l = s.charAt(left++);
                if (tMap.containsKey(l)) {
                    if (tMap.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return s.substring(minL, minR);
    }

    /**
     * 用于检测窗口是否覆盖了子串
     *
     * @return
     */
    private static boolean check() {
        for (Character key : tMap.keySet()) {
            int val = tMap.get(key);
            if (sMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
