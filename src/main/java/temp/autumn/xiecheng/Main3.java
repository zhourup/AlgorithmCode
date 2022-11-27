package temp.autumn.xiecheng;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        doSome(nums, k);
    }

    private static void doSome(int[] nums, int k) {
        if (k >= nums.length) {
            System.out.println(0);
            return;
        }

        System.out.println(0);
    }
}
