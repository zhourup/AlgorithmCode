package main.java.hot100;

public class Hot8 {

    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    /**
     * 实现将字符串换成一个32位有符号整数
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String s1 = "";
        int temp;
        if (s.charAt(0) == '-') {
            temp = 0;
            s1 = s.substring(1, s.length());
        } else if (s.charAt(0) == '+') {
            temp = 1;
            s1 = s.substring(1, s.length());
        } else {
            temp = 1;
            s1 = s;
        }
        int i;
        for (i = 0; i < s1.length(); i++) {
            if (!isLeaglChar(s1.charAt(i))) {
                break;
            }
        }
        s1 = s1.substring(0, i);
        if (s1.length() == 0) {
            return 0;
        }
        if (isInt(s1)) {
            if (temp == 0) {
                s1 = "-" + s1;
            }
            return Integer.parseInt(s1);
        }
        if (temp == 0) {
            return Integer.MIN_VALUE;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * 判断字符是否是0-9的数字
     *
     * @param c
     * @return
     */
    private static boolean isLeaglChar(char c) {
        int num = c;
        if (num >= 48 && num <= 57) {
            return true;
        }
        return false;
    }

    /**
     * 利用异常机制判断字符串转化成数字是否在整数表示范围内
     *
     * @param val
     * @return
     */
    private static boolean isInt(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
