package main.java.str;

/**
 * @author zhourup
 * @date 2022/3/29 23:21
 */
public class LeetCode409 {

    public static void main(String[] args) {
        String s = "bananas";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        int res = 0;
        for (int v : count) {
            res += v / 2 * 2;
            if (v % 2 == 1 && res % 2 == 0) {
                //当这个字符有奇数个，且总的还没有单个中心可加1
                res++;
            }
        }
        return res;
    }
}
