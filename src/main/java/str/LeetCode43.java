package main.java.str;

/**
 * @author zhourup
 * @date 2022/5/3 12:32
 */
public class LeetCode43 {

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiply(num1, num2));
    }

    /**
     * nums1[i]和nums2[j]的乘积对应的就是res[i+j]和res[i+j+1]这两个位置
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        //从个位开始逐味相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                sum += res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        //结果前缀可能存的0，未使用的位
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
