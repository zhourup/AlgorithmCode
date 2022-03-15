package main.java.hot100;

import java.util.Stack;

public class Hot85 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(maximalRectangle1(matrix));

    }

    /**
     * 法一、暴力 O(m^2n)
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = 1 + (j == 0 ? 0 : left[i][j - 1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }

    /**
     * 法二、单调栈
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = 1 + (j == 0 ? 0 : left[i][j - 1]);
                }
            }
        }
        int res = 0;
        //对每一列使用基于柱状图的办法
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Stack<Integer> stack = new Stack<>();
            //从上往下遍历，针对每一行，找出小于或等于left[i][j]的边界
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                int area = left[i][j] * (up[i] - down[i] - 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
