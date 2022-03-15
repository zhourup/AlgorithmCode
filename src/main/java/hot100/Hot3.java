package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhourup
 * 无重复字符的最长子串
 */
public class Hot3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //不管是否更新left,都要更新s.charAt(i)的位置
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

}
