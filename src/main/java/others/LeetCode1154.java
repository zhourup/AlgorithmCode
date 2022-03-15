package main.java.others;

/**
 * @author zhourup
 * @date 2021/12/21 17:18
 */
public class LeetCode1154 {

    public static void main(String[] args) {
        String s = "2004-03-01";
        System.out.println(dayOfYear1(s));
    }

    /**
     * 法一
     *
     * @param date
     * @return
     */
    public static int dayOfYear(String date) {
        String[] str = date.split("-");
        String y = str[0];
        String m = str[1];
        String d = str[2];
        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(y);
        int month = 0;
        if (m.charAt(0) == '0') {
            month = Integer.parseInt(m.substring(1));
        } else {
            month = Integer.parseInt(m);
        }
        int day = 0;
        if (d.charAt(0) == '0') {
            day = Integer.parseInt(d.substring(1));
        } else {
            day = Integer.parseInt(d);
        }
        int num = 0;
        if (isYunYear(year)) {
            months[2] = 29;
        }
        for (int i = 1; i < month; i++) {
            num = num + months[i];
        }
        num = num + day;
        return num;
    }

    private static boolean isYunYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    /**
     * 法二
     *
     * @param date
     * @return
     */
    public static int dayOfYear1(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            months[2]++;
        }
        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += months[i];
        }
        return ans + day;
    }
}
