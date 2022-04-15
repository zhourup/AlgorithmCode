package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/15 20:54
 */
public class LeetCode319 {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(bulbSwitch(n));
    }

    /**
     * 在第i轮时，将编号为i的倍数的灯泡进行切换
     * 因此，对于第k个灯泡，它被切换的次数切好就是k的约数个数。如果k有偶数个约数，那么k最终的状态为暗，如果k有奇数个约数，最终为亮
     * 当k是完全平方数时，它有奇数个约数，否则有偶数个约数
     * 因此我们只需要找1,2,3...n中的完全平方数的个数即可
     *
     * @param n
     * @return
     */
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
