package main.java.dp;

public class LeetCode221 {

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] chars1 = {
                {'0', '1'},
                {'1', '0'},
        };
        char[][] chars2 = {
                {'0', '1'},
        };
        System.out.println(maximalSquare(chars));
    }

    /**
     * 法一：暴力法
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLen = Math.max(maxLen, maxLenSquare(matrix, i, j));
            }
        }
        return maxLen * maxLen;
    }

    private static int maxLenSquare(char[][] matrix, int x, int y) {
        int max = 0;
        int len = Math.min(matrix.length - x, matrix[0].length - y);
        for (int k = 1; k <= len; k++) {
            if (isValidSquare(matrix, x, y, k)) {
                max = Math.max(max, k);
            }
        }
        return max;
    }

    private static boolean isValidSquare(char[][] matrix, int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 法二：动态规划
     * dp[i][j]表示以(i,j)为右下角的正方形的的最大边长
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}




























