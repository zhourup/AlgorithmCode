package temp.autumn.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        int[][] nums = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        System.out.println(getRes(nums, p, q, n));
    }

    private static int getRes(int[][] nums, int p, int q, int n) {
        Long[] one = new Long[n + 1];
        Long[] two = new Long[n + 1];
        Arrays.fill(one, 0L);
        Arrays.fill(two, 0L);
        for (int i = 0; i < nums[0].length; i++) {
            int l = nums[0][i];
            int r = nums[1][i];
            int t = nums[2][i];
            for (int j = l; j <= r; j++) {
                if (t == 1) {
                    one[j]++;
                } else {
                    two[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (one[i] >= p && two[i] >= q) {
                count++;
            }
        }
        return count;
    }
}
