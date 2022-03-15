package main.java.temp.session11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * G:回文日期
 */
public class topic7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String time1 = null;
        String time2 = null;
        boolean flag1 = true;
        boolean flag2 = true;

        String time = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
        System.out.println("time:" + time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = null;
        try {
            dBegin = sdf.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        while (flag1 || flag2) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayStr = sdf.format(calBegin.getTime());
            System.out.println(dayStr);
            if (flag1 && isPalindrome(dayStr)) {
                time1 = dayStr;
                flag1 = false;
            }
            if (flag2 && isABAPalindrome(dayStr)) {
                time2 = dayStr;
                flag2 = false;
            }
        }
        System.out.println("finish...");
        System.out.println("time1:" + time1.replace("-",""));
        System.out.println("time2:" + time2.replace("-",""));
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.replace("-", "");
        int len = s1.length();
        for (int i = 0; i < len / 2; i++) {
            if (s1.charAt(i) != s1.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isABAPalindrome(String s1) {
        String s = s1.replace("-", "");
        if (!isPalindrome(s)) {
            return false;
        }
        return (s.charAt(0) == s.charAt(2) && s.charAt(2) == s.charAt(5) && s.charAt(5) == s.charAt(7)) &&
                (s.charAt(1) == s.charAt(3) && s.charAt(3) == s.charAt(4) && s.charAt(4) == s.charAt(6));
    }

}
