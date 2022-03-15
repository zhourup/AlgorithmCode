package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/11 10:58
 */
public class Sword15 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(hammingWeight(n));
    }

    /**
     * 法一、循环检查二进制位
     *
     * @param n
     * @return
     */
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
