package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/8 14:29
 */
public class Sword4 {

    public static void main(String[] args) {
        int[][] nums = {
        };
        int target = 0;
        System.out.println(findNumberIn2DArray(nums, target));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            while (j >= 0 && matrix[i][j] > target) {
                j--;
            }
            if (j < 0) {
                return false;
            }
            while (i < m && matrix[i][j] < target) {
                i++;
            }
            if (i >= m) {
                return false;
            }
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
