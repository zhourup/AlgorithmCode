package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/10/24 9:50
 */
public class Hot240 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {-5}
        };
        int target = -10;
        System.out.println(searchMatrix(nums, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
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
            if (i == m) {
                return false;
            }
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
