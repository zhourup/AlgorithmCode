package main.java.weekcompetition.week288;

/**
 * @author zhourup
 * @date 2022/4/10 10:47
 */
public class LeetCode6038 {

    public static void main(String[] args) {
        String s = "999+999";
        System.out.println(minimizeResult(s));
    }

    public static String minimizeResult(String expression) {
        String[] str = expression.split("[+]");
        int min = Integer.MAX_VALUE;
        String res = "";
        //左括号插入位置
        for (int i = 0; i < str[0].length(); i++) {
            //右括号插入位置
            for (int j = 1; j <= str[1].length(); j++) {
                String pre = str[0].substring(0, i) + "(" + str[0].substring(i);
                String last = str[1].substring(0, j) + ")" + str[1].substring(j);
                String reqStr = pre + "+" + last;
                int value = getStrValue(reqStr);
                if (value < min) {
                    min = value;
                    res = reqStr;
                }
            }
        }
        return res;
    }

    /**
     * 求带括号的字符串值
     *
     * @param s
     * @return
     */
    private static int getStrValue(String s) {
        int a, b, c, d;
        String[] str = s.split("[+]");
        String[] str1 = str[0].split("[(]");
        if (str1[0].equals("")) {
            a = 1;
            b = Integer.parseInt(str1[1]);
        } else {
            a = Integer.parseInt(str1[0]);
            b = Integer.parseInt(str1[1]);
        }
        String[] str2 = str[1].split("[)]");
        if (str2.length == 1) {
            c = Integer.parseInt(str2[0]);
            d = 1;
        } else {
            c = Integer.parseInt(str2[0]);
            d = Integer.parseInt(str2[1]);
        }
        return a * (b + c) * d;
    }
}
