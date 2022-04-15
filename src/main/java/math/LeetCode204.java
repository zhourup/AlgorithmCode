package main.java.math;

import java.util.Arrays;

/**
 * @author zhourup
 * @date 2022/4/14 23:40
 */
public class LeetCode204 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    /**
     * 给定n,返回小于n的质数的数量
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
