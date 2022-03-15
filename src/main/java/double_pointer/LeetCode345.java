package main.java.double_pointer;

public class LeetCode345 {
    public static void main(String[] args) {
        String s = ".,";
        System.out.println(reverseVowels(s));
    }

    /**
     * 方法一，双指针
     *
     * @param s s
     * @return String
     */
    public static String reverseVowels(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();
        while (left <= right) {
            while (!isVowelLetter(str[left]) && left < str.length - 1) {
                left++;
            }
            while (!isVowelLetter(str[right]) && right > 0) {
                right--;
            }
            if (left <= right) {
                char ch = str[left];
                str[left++] = str[right];
                str[right--] = ch;
            }
        }
        return String.valueOf(str);
    }

    private static boolean isVowelLetter(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

}
