package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/14 14:55
 */
public class LeetCode172 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(trailingZeroes(n));
    }

    /**
     * 末尾有0是因为两个数中有因子2和5 因为10=2*5
     * 1、问题转化为：n!最多可以分解出多少个因子2和5
     * 主要取决于能分解出几个因子5，因为每个偶数都能分解出因子2，因子2肯定比因子5多的多
     * 25！时，5提供一个，10一个，15一个，20一个，25两个，总共有6个因子5，所以25!的结果末尾有6个0
     * <p>
     * 2、问题转化为n!最多能分解出几个因子5
     * <p>
     * 思路：先求出是5的倍数的数量，再求出是25倍数的数量，再求出125倍数的数量。。。
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int res = 0;
        int div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
