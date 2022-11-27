package temp.autumn.meituan;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getMax(nums));
    }

    private static int getMax(int[] nums) {
        return getMaxNode(nums, 1);
    }

    private static int getMaxNode(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int left = getMaxNode(nums, 2 * index);
        int right = getMaxNode(nums, 2 * index + 1);
        return nums[index] + Math.max(left, right);
    }
}
