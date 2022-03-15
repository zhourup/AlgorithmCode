package main.java.str;

import java.util.Scanner;

public class LeetCode557 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(reverseWords1(s));
    }

    /**
     * 方法一
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--) {
            stringBuilder.append(str[i] + " ");
        }
        stringBuilder.append(str[0]);
        return stringBuilder.reverse().toString();
    }

    /**
     * 方法二
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        StringBuffer ret=new StringBuffer();
        int len=s.length();
        int i=0;
        while (i<len){
            int start=i;
            while (i<len&&s.charAt(i)!=' '){
                i++;
            }
            for (int p=start;p<i;p++){
                ret.append(s.charAt(start+i-1-p));
            }
            while (i<len&&s.charAt(i)==' '){
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
