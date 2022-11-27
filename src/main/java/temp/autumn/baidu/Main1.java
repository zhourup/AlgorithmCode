package temp.autumn.baidu;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        count(nums);
    }

    private static void count(int[] nums) {
        int comment = 0, zan = 0;
        for (int num : nums) {
            if (num == 1) {
                comment++;
            } else if (num == 2) {
                zan++;
            } else if (num == 3) {
                if (comment > zan) {
                    comment++;
                } else if (zan > comment) {
                    zan++;
                } else {
                    comment++;
                    zan++;
                }
            }
        }
        System.out.println(comment + " " + zan);
    }
}
