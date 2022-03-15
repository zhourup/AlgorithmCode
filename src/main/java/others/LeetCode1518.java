package main.java.others;

/**
 * @author zhourup
 * @date 2021/12/17 14:49
 */
public class LeetCode1518 {

    public static void main(String[] args) {
        int a = 9;
        int b = 3;
        System.out.println(numWaterBottles(a, b));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int kong = numBottles;
        while (kong >= numExchange) {
            int curr = kong / numExchange;
            res = res + curr;
            kong = curr + kong % numExchange;
        }

        return res;
    }
}
