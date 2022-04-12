package main.java.math;

/**
 * @author zhourup
 * @date 2022/4/12 21:57
 */
public class LeetCode191 {

    public static void main(String[] args) {

    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
