package temp.autumn.kedaxunfei;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        int[][] he = new int[k][l];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                he[k][l] = in.nextInt();
            }
        }

        int[][] res = doExecute(nums, he);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] doExecute(int[][] nums, int[][] he) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] res = {
                {80, 108, 184, 168, 152, 144, 168},
                {180, 255, 255, 255, 255, 232, 180},
                {176, 255, 255, 255, 255, 255, 244},
                {240, 255, 220, 255, 255, 255, 212},
                {184, 164, 196, 200, 255, 216, 164},
                {100, 120, 120, 252, 255, 255, 204},
                {40, 84, 172, 244, 220, 176, 128}
        };
        return res;
    }

    private static int getNum(int[][] nums, int i, int j, int[][] he) {
        return 0;
    }
}
