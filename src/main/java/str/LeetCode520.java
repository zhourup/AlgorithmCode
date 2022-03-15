package main.java.str;

import java.util.Scanner;

public class LeetCode520 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String word=in.nextLine();
        System.out.println(detectCapitalUse(word));
    }

    /**
     * 方法一
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        if (isLegal1(word)||isLegal2(word)||isLegal3(word))
            return true;
        else
            return false;
    }

    private static boolean isLegal1(String word){
        for (int i=0;i<word.length();i++){
            if (!(word.charAt(i)>='A'&&word.charAt(i)<='Z'))
                return false;
        }
        return true;
    }

    private static boolean isLegal2(String word){
        for (int i=0;i<word.length();i++){
            if (!(word.charAt(i)>='a'&&word.charAt(i)<='z'))
                return false;
        }
        return true;
    }

    private static boolean isLegal3(String word){
        if (word.charAt(0)<'A'||word.charAt(0)>'Z')
            return false;

        for (int i=1;i<word.length();i++){
            if (!(word.charAt(i)>='a'&&word.charAt(i)<='z'))
                return false;
        }
        return true;
    }

    /**
     * 方法二
     * @param word
     * @return
     */
    public static boolean detectCapitalUse1(String word) {
        int len=word.length();
        int count=0;
        for (int i=0;i<len;i++){
            char c=word.charAt(i);
            if (c>='A'&&c<='Z'){
                count++;
            }
        }
        return count==len||count==0||(count==1&&word.charAt(0)>='A'&&word.charAt(0)<='Z');
    }
}
