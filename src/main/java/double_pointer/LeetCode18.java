package main.java.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2021/12/9 0:04
 */
public class LeetCode18 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = threeSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //避免第一个数选择相同
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * 返回从下标start开始，和为target的两个数，不能重复
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    private static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;
        while (l < r) {
            int left = nums[l], right = nums[r];
            int sum = left + right;
            if (sum < target) {
                while (l < r && nums[l] == left) {
                    l++;
                }
            } else if (sum > target) {
                while (l < r && nums[r] == right) {
                    r--;
                }
            } else {
                List<Integer> list = new ArrayList<>(4);
                list.add(left);
                list.add(right);
                res.add(list);
                while (l < r && nums[l] == left) {
                    l++;
                }
                while (l < r && nums[r] == right) {
                    r--;
                }
            }
        }
        return res;
    }

    /**
     * 根据规律总结出nSum,即nums数组中n个数和为target的组合，一个组合中每个位置的数只能用一次，且组合之间不能存在顺序上的差别而数一样
     * <p>
     * 注意：调用该方法之前，应先对nums排序
     *
     * @param nums   数组
     * @param n      求n个数的组合
     * @param start  从数组start为下标开始找
     * @param target 要求和为target
     * @return
     */
    private static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sz = nums.length;
        //至少是2sum，且数组大小不应该小于n
        if (n < 2 || sz < n) {
            return res;
        }
        if (n == 2) {
            int l = start, r = sz - 1;
            while (l < r) {
                int left = nums[l], right = nums[r];
                int sum = left + right;
                if (sum < target) {
                    while (l < r && nums[l] == left) {
                        l++;
                    }
                } else if (sum > target) {
                    while (l < r && nums[r] == right) {
                        r--;
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (l < r && nums[l] == left) {
                        l++;
                    }
                    while (l < r && nums[r] == right) {
                        r--;
                    }
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
