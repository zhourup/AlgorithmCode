package main.java.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode268 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(missingNumber1(nums));
    }

    /**
     * 法五、位运算，相同数异或为0：a^a=0   任意数和0异或为其本身:  a^0=a
     * 将数和索引异或
     *
     * @param nums
     * @return
     */
    public static int missingNumber5(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        res ^= n;
        return res;
    }

    /**
     * 法四、等差数列
     *
     * @param nums
     * @return
     */
    public static int missingNumber4(int[] nums) {
        //等差数列
        int n = nums.length;
        long expect = (n * (1 + n)) / 2;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int) (expect - sum);
    }

    /**
     * 方法一
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        for (int i = 0; i < len; i++)
            temp[i] = 0;

        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0)
                return i;
        }
        return 0;
    }

    /**
     * 方法二：排序后再判断
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    /**
     * 方法三：哈希表
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);
        int ex = nums.length + 1;
        for (int i = 0; i < ex; i++) {
            if (!numSet.contains(i))
                return i;
        }
        return -1;
    }

}
