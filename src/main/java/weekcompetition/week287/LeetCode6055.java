package main.java.weekcompetition.week287;

/**
 * @author zhourup
 * @date 2022/4/3 10:30
 */
public class LeetCode6055 {

    public static void main(String[] args) {
        String current = "11:00";
        String correct = "11:01";
        System.out.println(convertTime(current, correct));
    }

    public static int convertTime(String current, String correct) {
        int from = timeToNum(current);
        int to = timeToNum(correct);
        int need = Math.abs(from - to);
        int count = 0;
        if (need >= 60) {
            int a = need / 60;
            count += a;
            need = need % 60;
        }
        if (need >= 15) {
            int a = need / 15;
            count += a;
            need = need % 15;
        }
        if (need >= 5) {
            int a = need / 5;
            count += a;
            need = need % 5;
        }
        return count + need;
    }

    /**
     * 将时间转化为数字
     *
     * @param time
     * @return
     */
    private static int timeToNum(String time) {
        int num = 0;
        if (time.charAt(0) != '0') {
            num = num + 60 * Integer.parseInt(time.substring(0, 2));
        } else {
            num = num + 60 * Integer.parseInt(time.substring(1, 2));
        }
        num = num + 10 * Integer.parseInt(time.substring(3, 4));
        num = num + Integer.parseInt(time.substring(4, 5));
        return num;
    }
}
