package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/15 15:31
 */
public class LeetCode292 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(canWinNim(n));
    }

    /**
     * 到我的时候，1-3颗石子可以赢，所以得让对手有4颗
     * 为了让对手有4颗，我得有5-7颗，所以就得对手有8颗
     * 总结：我赢，n就不能是4的倍数
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
