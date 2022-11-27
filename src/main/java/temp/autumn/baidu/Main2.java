package temp.autumn.baidu;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }
        System.out.println(minOperateTime(nums));
    }

    private static long minOperateTime(long[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            if (nums[0] == nums[1]) {
                return 0;
            } else {
                return -1;
            }
        }

        long count = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] < nums[right]) {
                long cha = nums[right] - nums[left];
                nums[left] += cha;
                if (left + 1 >= right) {
                    return -1;
                }
                nums[left + 1] += cha;
                count += cha;
            } else if (nums[left] >= nums[right]) {
                long cha = nums[left] - nums[right];
                nums[right] += cha;
                if (right - 1 <= left) {
                    return -1;
                }
                nums[right - 1] += cha;
                count += cha;
            }
        }
        return count;
    }
}
