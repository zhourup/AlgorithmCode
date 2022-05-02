package main.java.others;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/5/2 22:54
 */
public class EatGrapes {


    public static void main(String[] args) {
        long a = 1;
        long b = 1;
        long c = 1;
        System.out.println(solution(a, b, c));
    }

    /**
     * 有三种葡萄，分别是a,b,c颗
     * 第一个人只吃1,2种葡萄，第二个人只吃2,3种葡萄，第三个人只吃1,3种葡萄
     * 适当安排三个人吃完所有的葡萄，并且三个人中吃的最多的那个人吃的尽量少
     * <p>
     * 怎么让吃的最多的那个人吃的最少？尽可能平均，吃的最躲那个人向上取整(a+b+c+2)/3
     *
     * @param a
     * @param b
     * @param c
     * @return 三个人中吃的最多的那个人的数量
     */
    public static long solution(long a, long b, long c) {
        long[] nums = new long[]{a, b, c};
        Arrays.sort(nums);
        long sum = a + b + c;
        //能构成三角形，可完全平分
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }
        //不能构成三角形，平分最长变的情况
        if (2 * (nums[0] + nums[1]) < nums[2]) {
            return (nums[2] + 1) / 2;
        }
        //不能构成三角形，但依然可以完全平分的情况
        return (sum + 2) / 3;
    }
}
