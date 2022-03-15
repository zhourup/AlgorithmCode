package main.java.hash;

import java.util.Arrays;

public class LeetCode389 {

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(findTheDifference2(s, t));
    }

    /**
     * 方法一、先排序
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s.length(); i++) {
            if (s2[i] != s1[i])
                return s2[i];
        }
        return s2[t.length() - 1];
    }

    /**
     * 法二、异或运算   时间复杂度:O(m+n)   空间复杂度O(1)
     * 一个数和0做异或运算等于本身： a^0=a
     * 一个数和其本身异或运算等于0： a^a=0
     * 异或运算满足交换律
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference1(String s, String t) {
        char ans = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }

    /**
     * 法三
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        return (char) Math.abs(sumChars(s)-sumChars(t));
    }

    public static int sumChars(String str){
        int sum=0;
        for (char c:str.toCharArray()){
            sum+=c;
        }
        return sum;
    }

}
