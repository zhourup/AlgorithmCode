package main.java.weekcompetition.week288;

/**
 * @author zhourup
 * @date 2022/4/10 10:30
 */
public class LeetCode6037 {

    public static void main(String[] args) {
        int num = 65875;
        System.out.println(largestInteger(num));
    }

    public static int largestInteger(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % 2 != nums[i] % 2) {
                    continue;
                }
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }
            if (nums[index] > nums[i]) {
                char tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        String s = String.valueOf(nums);
        return Integer.parseInt(s);
    }
}
