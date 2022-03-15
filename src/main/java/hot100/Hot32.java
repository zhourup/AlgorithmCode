package main.java.hot100;

/**
 * 找出最长有效的 括号子串 的长度
 *
 * @author zhourup
 */
public class Hot32 {

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }

    /**
     * 法一、动态规划
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[1] = chars[0] == '(' && chars[1] == ')' ? 2 : 0;
        int max = dp[1];
        for (int i = 2; i < s.length(); i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else {
                if (chars[i - 1] == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    if (i - dp[i - 1] - 1 < 0 || chars[i - dp[i - 1] - 1] == ')') {
                        dp[i] = 0;
                    } else {
                        dp[i] = i - dp[i - 1] - 1 >= 1 ? 2 + dp[i - 1] + dp[i - dp[i - 1] - 2] : 2 + dp[i - 1];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
