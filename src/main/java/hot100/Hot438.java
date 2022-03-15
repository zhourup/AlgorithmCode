package main.java.hot100;

import java.util.*;

/**
 * @author zhourup
 * @date 2021/11/18 14:23
 */
public class Hot438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams1(s, p));

    }

    /**
     * 法一
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }


    /**
     * 法二
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (pMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (pMap.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (valid == pMap.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char l = s.charAt(left++);
                if (pMap.containsKey(l)) {
                    if (pMap.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return res;
    }
}





















