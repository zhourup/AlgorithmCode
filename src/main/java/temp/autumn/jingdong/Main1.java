package temp.autumn.jingdong;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            max = Math.max(max, nums[i]);
        }
        System.out.println(getJiaNum(nums, max));
    }

    private static int getJiaNum(int[] nums, int max) {
        if (nums.length <= 1) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num < max) {
                count++;
            }
        }
        return count;
    }
}
