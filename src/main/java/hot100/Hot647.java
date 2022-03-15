package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/13 15:57
 */
public class Hot647 {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings2(s));

    }

    /**
     * 法三、动态规划
     * dp[i][j]表示字符串s在[i,j]区间的子串是否是一个回文串
     * <p>
     * 因为dp[i][j]的情况要依赖于dp[i+1][j-1]，所以矩阵的遍历一定要从下到上，从左到右，保证dp[i+1][j-1]都是经过计算的
     *
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 法二、中心拓展法
     * 如果回文串是奇数，我们把回文串中心那个字符叫做中心点，如果回文串是偶数，我们就把中间那两个字符叫做中心点
     * 对于一个长度为n的字符串，我们可以用它的任意一个字符当做中心点，所以中心点的个数是n
     * 我们还可以用它任意挨着的两个字符当做中心点，所以中心点是n-1，总的中心点就是2*n-1
     *
     * @param s
     * @return
     */
    public static int countSubstrings1(String s) {
        int n = s.length(), count = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }

    /**
     * 法一、暴力
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                if (i + len > n) {
                    break;
                }
                if (isPalindromeStr(s.substring(i, i + len))) {
                    count++;
                }
            }
        }
        return count + s.length();
    }

    private static boolean isPalindromeStr(String s) {
        int n = s.length();
        if (n <= 1) {
            return true;
        }
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
