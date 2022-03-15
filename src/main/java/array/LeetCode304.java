package main.java.array;

/**
 * @author zhourup
 * @date 2022/1/2 11:07
 */
public class LeetCode304 {

    /**
     * 维护一个二维preSum数组，专门记录以原点为顶点的矩阵元素之和，就可以用几次加减运算算出任何一个子矩阵的元素和
     */
    static class NumMatrix {
        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        NumMatrix numMatrix = new NumMatrix(nums);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
    }


}
