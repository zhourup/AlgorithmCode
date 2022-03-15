package main.java.notes;

/**
 * 给你一个二维数组，二维数组中的每一个数都是正数，要求从左上角走到右下角，每一步只能从向右或者向下。沿途经过的数字要累加起来。
 * 返回最小的路径和。
 */
public class Code_07_MinPath {

    // 从(i,j)出发，到达最右下角位置，最小路径和是多少?(返回)
    public static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        int right = walk(matrix, i, j + 1);
        int down = walk(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }
}
