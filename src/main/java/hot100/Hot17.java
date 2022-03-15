package main.java.hot100;

import java.util.*;

public class Hot17 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations2(digits).toString());

    }

    /**
     * 法三、广度优先，队列
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] st = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String str = st[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String temp = res.remove(0);
                for (int k = 0; k < str.length(); k++) {
                    res.add(temp + str.charAt(k));
                }
            }
        }
        return res;
    }

    /**
     * 法二、深度优先, 递归
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res, map, digits, 0, new StringBuffer());
        return res;
    }

    /**
     * @param res    最终结果
     * @param map    存储字符的map
     * @param digits 输入的数字
     * @param index  记录递归到digits的具体哪个下表
     * @param sb     暂存结果的StringBuffer
     */
    private static void backtrack(List<String> res, Map<Character, String> map, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String str = map.get(digit);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                backtrack(res, map, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }

    /**
     * 法一、比较笨的办法，知道长度为1-4,依次判断每种情况的相应处理方式
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] st = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 1) {
            int index = Integer.parseInt(digits) - 2;
            for (int i = 0; i < st[index].length(); i++) {
                result.add(String.valueOf(st[index].charAt(i)));
            }
        } else if (digits.length() == 2) {
            int index1 = Integer.parseInt(String.valueOf(digits.charAt(0))) - 2;
            int index2 = Integer.parseInt(String.valueOf(digits.charAt(1))) - 2;
            for (int i = 0; i < st[index1].length(); i++) {
                for (int j = 0; j < st[index2].length(); j++) {
                    result.add(st[index1].charAt(i) + "" + st[index2].charAt(j));
                }
            }
        } else if (digits.length() == 3) {
            int index1 = Integer.parseInt(String.valueOf(digits.charAt(0))) - 2;
            int index2 = Integer.parseInt(String.valueOf(digits.charAt(1))) - 2;
            int index3 = Integer.parseInt(String.valueOf(digits.charAt(2))) - 2;
            for (int i = 0; i < st[index1].length(); i++) {
                for (int j = 0; j < st[index2].length(); j++) {
                    for (int k = 0; k < st[index3].length(); k++) {
                        result.add(st[index1].charAt(i) + "" + st[index2].charAt(j) + st[index3].charAt(k));
                    }
                }
            }
        } else {
            int index1 = Integer.parseInt(String.valueOf(digits.charAt(0))) - 2;
            int index2 = Integer.parseInt(String.valueOf(digits.charAt(1))) - 2;
            int index3 = Integer.parseInt(String.valueOf(digits.charAt(2))) - 2;
            int index4 = Integer.parseInt(String.valueOf(digits.charAt(3))) - 2;
            for (int i = 0; i < st[index1].length(); i++) {
                for (int j = 0; j < st[index2].length(); j++) {
                    for (int k = 0; k < st[index3].length(); k++) {
                        for (int l = 0; l < st[index4].length(); l++) {
                            result.add(st[index1].charAt(i) + "" + st[index2].charAt(j) + st[index3].charAt(k) + st[index4].charAt(l));
                        }
                    }
                }
            }
        }
        return result;
    }

}
