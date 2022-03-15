package main.java.binary_search;

/**
 * @author zhourup
 * @date 2022/1/3 14:56
 */
public class LeetCode875 {

    public static void main(String[] args) {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    /**
     * 思路：
     * 1、确定x,f(x),target分别是什么，并写出函数f的函数
     * 吃香蕉的速度就是自变量x
     * f(x)函数定义：若吃香蕉的速度为x根/小时，则需要f(x)小时吃完所有香蕉
     * target就很明显了，时间限制H就是target
     * 2、找到x的取值范围作为二叉搜索的搜索区间，初始化left和right变量
     * 显然最小速度应该是1，最大熟读就是piles数组中元素的最大值
     *
     * @param piles
     * @param h
     * @return
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int need = getEatTime(piles, mid);
            if (need == h) {
                //需要让自变量小点
                right = mid - 1;
            } else if (need > h) {
                //需要让need小一点，自变量越大，need越小
                left = mid + 1;
            } else if (need < h) {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int getEatTime(int[] piles, int k) {
        int time = 0;
        for (int pile : piles) {
            int quot = pile / k;
            int remain = pile % k;

            time += quot;
            if (remain != 0) {
                time += 1;
            }
        }
        return time;
    }

    private int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
}
