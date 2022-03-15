package main.java.stack;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Integer> linkedList;

    public MyQueue() {
        linkedList = new LinkedList<Integer>();
    }

    public void push(int x) {
        linkedList.add(x);
    }

    public int pop() {
        int result = linkedList.get(0);
        linkedList.remove(0);
        return result;
    }

    public int peek() {
        return linkedList.get(0);
    }

    public boolean empty() {
        return linkedList.isEmpty();
    }
}
