package main.java.sword;

import java.util.Stack;

/**
 * @author zhourup
 * @date 2022/3/9 22:04
 */
public class Sword9 {

    static class CQueue {

        //两个栈，一个入栈，一个出栈
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.isEmpty() ? -1 : stack2.pop();
            }
        }
    }

    public static void main(String[] args) {
    }
}
