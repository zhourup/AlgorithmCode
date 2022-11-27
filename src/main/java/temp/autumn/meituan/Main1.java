package temp.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getUseTime(nums, t));
    }

    private static int getUseTime(int[] nums, int t) {
        int times = 0;
        Arrays.sort(nums);
        int curr = t;
        for (int i = 0; i < nums.length; i++) {
            if (curr <= nums[i]) {
                curr += t;
                continue;
            }
            times++;
        }
        return times;
    }
}
