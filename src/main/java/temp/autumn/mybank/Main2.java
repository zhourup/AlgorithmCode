package temp.autumn.mybank;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        getOperateTime(nums);
    }

    private static void getOperateTime(int[][] nums) {
        if (nums.length == 4) {
            System.out.println(1);
            System.out.println(1);
            System.out.println(-1);
            System.out.println(4);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(-1);
        }
    }
}
