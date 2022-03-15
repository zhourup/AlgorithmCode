package main.java.double_pointer;

import java.util.Arrays;

public class LeetCode977 {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] result = sortedSquares1(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(result[i] + " ");

    }

    /**
     * 方法一，排序
     *
     * @param A A
     * @return result
     */
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 方法二，双指针
     *
     * @param A A
     * @return result
     */
    public static int[] sortedSquares1(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        int a = 0, b = len - 1, i = b;
        while (i >= 0) {
            int left = A[a] * A[a];
            int rig = A[b] * A[b];
            if (left > rig) {
                ans[i--] = left;
                a++;
            } else {
                ans[i--] = rig;
                b--;
            }
        }
        return ans;
    }
}
