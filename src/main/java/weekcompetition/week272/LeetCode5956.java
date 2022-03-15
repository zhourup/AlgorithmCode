package main.java.weekcompetition.week272;

/**
 * @author zhourup
 * @date 2021/12/19 10:30
 */
public class LeetCode5956 {

    public static void main(String[] args) {
        String[] word = new String[]{"notapalindrome", "racecar"};
        System.out.println(firstPalindrome(word));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isValidStr(word)) {
                return word;
            }
        }
        return "";
    }

    /**
     * 判断字符串是否为回文字符串
     *
     * @param str
     * @return
     */
    private static boolean isValidStr(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
