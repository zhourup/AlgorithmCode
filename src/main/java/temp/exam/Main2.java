package main.java.temp.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
//    第二题思路：
//    1、isValid()方法是判断这个方法就是判断字符串s是否符合match这个模式的，你可以自己写输入调用这个方法
//    2、先将字符串按' '分割成数组
//    3、定义一个哈希表，用于存模式中每个字符所对应的单词
//    4、从0开始遍历match的每一个字符，如果哈希表中没有该字符，则插入进去哈希表（字符，其对应的字符串）
//    5、如果该字符已经在哈希表，则判断该字符对应的字符串和当前字符串是否一样，若不一样则返回false
//    返回true

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String match = in.nextLine();
        String s = in.nextLine();
        System.out.println(isValid(match, s));
    }

    private static boolean isValid(String match, String s) {
        String[] str = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < match.length(); i++) {
            char c = match.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, str[i]);
            } else {
                if (!map.get(c).equals(str[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}