package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/12 22:28
 */
public class LeetCode231 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPowerOfTwo(n));
    }

    /**
     * 思路：一个数如果是2的指数，那么它的二进制一定只含有一个1
     * 而n&(n-1)可以消除最后一个1
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
