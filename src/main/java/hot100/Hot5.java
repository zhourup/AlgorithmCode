package main.java.hot100;

/**
 * @author zhourup
 * <p>
 * 5. 最长回文子串
 */
public class Hot5 {

    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));

    }

    /**
     * dp[i][j]=dp[i+1][j-1]
     * 动态规划：每一步的计算都尽可能的使用到之前计算的结果
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        //表示从i到j的字符串是不是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        //为了使dp[i][j]=dp[i+1][j-1]中的dp[i+1][j-1]是有值的，参考它左下角的值，所以填充dp时，需要先升序填列，再升序填行
        for (int l = 1; l < len; l++) {
            for (int i = 0; i < len; i++) {
                //计算右边界
                int j = i + l;
                if (j >= len) {
                    break;
                }
                if (chars[i] == chars[j]) {
                    if (j - i > 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j] && (j - i > right - left)) {
                            left = i;
                            right = j;
                        }
                    } else {
                        dp[i][j] = true;
                        if (j - i > right - left) {
                            left = i;
                            right = j;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(left, right + 1);
    }


    /**
     * 时间O(n^2) 空间O(n^2)的答案
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int L = 0; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * O(N^2)
     * 枚举所有的回文中心，并尝试拓展，直到无法拓展为止
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    /**
     * O(N)
     * Manacher算法 专门用于查找最长回文子串的算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        return "ab";
    }


}
