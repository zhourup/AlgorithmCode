package main.java.queue;

import java.util.LinkedList;

public class MyStack {
    LinkedList linkedList;

    public MyStack() {
        linkedList = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        linkedList.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int len = linkedList.size();
        int temp = -1;
        if (len >= 1) {
            temp = (int) linkedList.get(len - 1);
            linkedList.remove(len - 1);
        }
        return temp;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int len = linkedList.size();
        int temp = -1;
        if (len >= 1) {
            temp = (int) linkedList.get(len - 1);
        }
        return temp;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return linkedList.size()==0;
    }
}
