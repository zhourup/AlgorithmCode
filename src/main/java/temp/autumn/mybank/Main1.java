package temp.autumn.mybank;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        getMax(nums);
    }

    public static void getMax(Integer[] nums) {
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }
        if (nums.length == 2) {
            String s1 = nums[0] + "" + nums[1];
            String s2 = nums[1] + "" + nums[2];
            long temp1 = Long.parseLong(s1);
            long temp2 = Long.parseLong(s2);
            if (temp1 > temp2) {
                System.out.println(temp1);
            } else {
                System.out.println(temp2);
            }
            return;
        }

        Long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    Long temp = help(nums[i], nums[j], nums[k]);
                    if (temp > res) {
                        res = temp;
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static Long help(int a, int b, int c) {
        String s1 = a + "" + b + "" + c;
        String s2 = a + "" + c + "" + b;
        String s3 = b + "" + a + "" + c;
        String s4 = b + "" + c + "" + a;
        String s5 = c + "" + a + "" + b;
        String s6 = c + "" + b + "" + a;
        Long max = 0L;
        long a1 = Long.parseLong(s1);
        if (a1 > max) {
            max = a1;
        }

        long b1 = Long.parseLong(s2);
        if (b1 > max) {
            max = b1;
        }

        long c1 = Long.parseLong(s3);
        if (c1 > max) {
            max = c1;
        }

        long d1 = Long.parseLong(s4);
        if (d1 > max) {
            max = d1;
        }

        long e1 = Long.parseLong(s5);
        if (e1 > max) {
            max = e1;
        }
        long f1 = Long.parseLong(s6);
        if (f1 > max) {
            max = f1;
        }
        return max;
    }
}
