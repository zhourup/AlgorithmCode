package main.java.binary_search;

public class LeetCode74 {

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(searchMatrix(nums, 13));
    }

    /**
     * 法一：递归二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length * matrix[0].length - 1;
        return binarySearch(matrix, 0, len, 3);
    }

    public static boolean binarySearch(int[][] matrix, int left, int right, int target) {
        int row = 0;
        int col = 0;
        boolean flag = false;
        int len = matrix[0].length;
        if (left <= right) {
            int mid = (left + right) / 2;
            row = mid / len;
            col = mid % len;
            System.out.println("mid:" + mid + " row:" + row + " col:" + col);
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                flag = binarySearch(matrix, left, mid - 1, target);
            } else {
                flag = binarySearch(matrix, mid + 1, right, target);
            }
        }
        return flag;
    }

    /**
     * 法二：迭代二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        int mid;
        int midElem;
        while (left <= right) {
            mid = (left + right) / 2;
            midElem = matrix[mid / n][mid % n];
            if (midElem == target) {
                return true;
            } else {
                if (target < midElem) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
