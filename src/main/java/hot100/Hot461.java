package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/13 21:33
 */
public class Hot461 {

    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        System.out.println(hammingDistance2(x, y));
    }

    /**
     * 法一
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        if (xStr.length() > yStr.length()) {
            int len = xStr.length() - yStr.length();
            for (int i = 0; i < len; i++) {
                yStr = '0' + yStr;
            }
        } else {
            int len = yStr.length() - xStr.length();
            for (int i = 0; i < len; i++) {
                xStr = '0' + xStr;
            }
        }
        int count = 0;
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i) != yStr.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 法二、内置位计数功能
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 法三、移位实现位计数
     * 利用异或操作：相同位异或得0，不同位异或得1，所以异或后1的个数即为需要返回的结果
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {
        int count = 0;
        int s = x ^ y;
        while (s > 0) {
            count = count + s & 1;
            s >>= 1;
        }
        return 0;
    }
}
