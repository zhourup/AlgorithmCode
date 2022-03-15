package main.java.weekcompetition.week273;

/**
 * @author zhourup
 * @date 2021/12/26 10:30
 */
public class LeetCode5963 {

    public static void main(String[] args) {
        int num = 0;
        System.out.println(isSameAfterReversals(num));
    }

    public static boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        if (num % 10 == 0) {
            return false;
        }
        return true;
    }
}
