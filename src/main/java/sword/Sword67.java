package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/30 20:50
 */
public class Sword67 {

    public static void main(String[] args) {
        String str = "    0000000000000   ";
        System.out.println(strToInt1(str));
    }

    /**
     * 法二
     *
     * @param str
     * @return
     */
    public static int strToInt1(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bnd = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            if (res > bnd || res == bnd && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    /**
     * 法一、过于繁琐
     *
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        if (str.length() == 1) {
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                return 0;
            }
            if (isValid(str.charAt(0))) {
                return Integer.parseInt(str);
            }
            return 0;
        }
        long res;
        //记录是否为负数
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
                if (str.charAt(0) == '-') {
                    flag = true;
                }
                continue;
            }
            //到达非法字符，准备返回
            if (!isValid(str.charAt(i))) {
                if (sb.length() == 0) {
                    return 0;
                }
                if (flag) {
                    //为负数
                    res = Long.parseLong('-' + sb.toString());
                } else {
                    //为正数
                    res = Long.parseLong(sb.toString());
                }
                return (int) res;
            }
            if (sb.length() == 0 && str.charAt(i) == '0') {
                continue;
            }
            sb.append(str.charAt(i));
            if (sb.length() > 10) {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }

        if (flag) {
            res = Long.parseLong('-' + sb.toString());
        } else {
            res = Long.parseLong(sb.toString());
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    private static boolean isValid(char c) {
        return c >= '0' && c <= '9';
    }
}
