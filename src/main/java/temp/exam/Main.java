package main.java.temp.exam;

import java.util.Scanner;

public class Main {
//    第一题思路：
//    1、先判断字符串长度是不是12，不是则直接返回false
//    2、判断字符串的索引为3和索引为7的字符是否为'-'，有任何一个不为-都返回-
//    3、判断剩余的几位是否都为数字，有任何一位不是数字则直接返回false，isNum（）这个函数是判断一个字符是不是0-9的
//    4、若以上条件都不满足，则返回true

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        if (s.length() != 12) {
            return false;
        }
        if (s.charAt(3) != '-' || s.charAt(7) != '-') {
            return false;
        }
        if (!isNum(s.charAt(0)) || !isNum(s.charAt(1)) || !isNum(s.charAt(2))
                || !isNum(s.charAt(4)) || !isNum(s.charAt(5)) || !isNum(s.charAt(6))
                || !isNum(s.charAt(8)) || !isNum(s.charAt(9)) || !isNum(s.charAt(10)) || !isNum(s.charAt(11))) {
            return false;
        }

        return true;
    }

    private static boolean isNum(char c) {
        return (c >= '0' && c <= '9');
    }
}