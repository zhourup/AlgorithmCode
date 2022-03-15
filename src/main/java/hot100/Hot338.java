package main.java.hot100;

/**
 * @author zhourup
 * @date 2021/11/9 11:04
 */
public class Hot338 {

    public static void main(String[] args) {
        int n = 7;
        int[] res = countBits2(n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 法一、Brian Kernighan 算法，时间复杂度O(NlogN)
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    public static int countOne(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 法二、二进制表示中，奇数比前面那个偶数多一个1，因为多的是最低位的1
     * 二进制表示中，偶数中的1的个数和它陈以2之后的数一样多，因为偶数最低位为0，除以2就是右移一位，把那个0抹掉
     *
     * @param n
     * @return
     */
    public static int[] countBits1(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }

    /**
     * 法三、动态规划-最高有效位
     *
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] res = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            res[i] = res[i - high] + 1;
        }
        return res;
    }

}
