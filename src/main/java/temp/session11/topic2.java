package main.java.temp.session11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * B:跑步锻炼
 */
public class topic2 {

    public static void main(String[] args) {
        String start = "2000-01-01";
        String end = "2020-10-02";
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dStart = null;
        Date dEnd = null;
        try {
            dStart = sdf.parse(start);
            dEnd = sdf.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dStart);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dEnd);
        while (calendar1.before(calendar2)) {
            String dStr = sdf.format(calendar1.getTime());
            if (calendar1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || isMonthFirstDay(dStr)) {
                count = count + 2;
                System.out.println("周一或者月初：" + dStr);
            } else {
                count++;
                System.out.println(dStr);
            }
            calendar1.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(count);
    }

    /**
     * 判断日期是否是当月的月初
     *
     * @param t
     * @return
     */
    public static boolean isMonthFirstDay(String t) {
        String s = t.replace("-", "");
        return (s.substring(6, 8).equals("01"));
    }
}
