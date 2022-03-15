package main.java.hot100;

public class Hot72 {

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance2(word1, word2));
    }

    /**
     * 法一、递归，可能会超时(存在大量重复计算)
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance1(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return minDistance1(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        }
        int insert = minDistance1(word1, word2.substring(0, word2.length() - 1));
        int del = minDistance1(word1.substring(0, word1.length() - 1), word2);
        int change = minDistance1(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        return 1 + Math.min(insert, Math.min(del, change));
    }

    /**
     * 法二、动态规划
     * 将字符串1变成字符串2需要进行的操作数
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return
     */
    public static int minDistance2(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        //边界初始化
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }

}
