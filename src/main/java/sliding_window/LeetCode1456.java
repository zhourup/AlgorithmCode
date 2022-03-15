package main.java.sliding_window;

public class LeetCode1456 {

    public static void main(String[] args) {
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        int k = 33;
        System.out.println(maxVowels(s, k));
    }

    /**
     * O(N)，滑动窗口
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {
        int max = 0;
        if (s.length() < k) {
            for (int i = 0; i < s.length(); i++) {
                if (isVowel(s.charAt(i))) {
                    max++;
                }
            }
            return max;
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * O(N^2)，会超出时间限制
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels1(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i; j < len && j < i + k; j++) {
                if (isVowel(chars[j])) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
