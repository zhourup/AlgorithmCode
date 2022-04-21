package main.java.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/15 23:14
 */
public class LeetCode241 {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> res = diffWaysToCompute(expression);
        for (Integer r : res) {
            System.out.println(r);
        }
    }

    /**
     * 运算符的优先级，可以将每个运算符优先的情况都计算出来
     * 枚举每个运算符左右两侧表达式加括号，再进行运算
     *
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
