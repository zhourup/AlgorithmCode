package main.java.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhourup
 * @date 2022/3/31 15:13
 */
public class LeetCode50 {

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        if (s.equals("")) {
            return ' ';
        }
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 128; i++) {
            if (count[i] == 1) {
                char c = (char) i;
                set.add(c);
            }
        }
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            }
        }
        return ' ';
    }
}
