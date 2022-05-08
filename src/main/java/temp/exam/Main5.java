package main.java.temp.exam;

import java.util.Scanner;

/**
 * @author zhourup
 * @date 2022/4/24 21:32
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getValue(n, m, nums));
    }

    private static int getValue(int n, int m, int[] prices) {
        return m;
    }
}

