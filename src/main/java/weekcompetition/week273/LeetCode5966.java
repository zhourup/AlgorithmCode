package main.java.weekcompetition.week273;

/**
 * @author zhourup
 * @date 2021/12/26 11:08
 */
public class LeetCode5966 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 10, 6, 4, 8, 12};
        int[] res = recoverArray(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }

    /**
     * 首先k要明确，将整数数组nums分为lower、higher，arr[i]-k在lower，arr[i]+k在higher
     *
     * @param nums
     * @return
     */
    public static int[] recoverArray(int[] nums) {
        return nums;
    }
}
