package main.java.double_pointer;

public class LeetCode344 {
    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        reverseString(str);
    }

    /**
     * 倒置字符数组
     *
     * @param s s
     */
    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char c = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = c;
        }
    }
}
