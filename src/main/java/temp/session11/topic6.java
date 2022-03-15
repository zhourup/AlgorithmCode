package main.java.temp.session11;

import java.util.Scanner;

/**
 * F:成绩统计
 */
public class topic6 {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int count1 = 0; //及格人数
        int count2 = 0; //优秀人数
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] >= 85) {
                count1++;
                count2++;
            } else if (nums[i] >= 60) {
                count1++;
            } else {
            }
        }
        double res1 = count1 / (n * 1.0);
        double res2 = count2 / (n * 1.0);
        System.out.println(Math.round(res1 * 100));
        System.out.println(Math.round(res2 * 100));
    }
}
