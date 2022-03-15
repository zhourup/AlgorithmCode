package main.java.stack;

import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> stack;

    public MinStack(){
        stack=new ArrayList<Integer>();
    }

    public void push(int x){
        stack.add(x);
    }

    public void pop(){
        stack.remove(stack.size()-1);
    }

    public int top(){
        return stack.get(stack.size()-1);
    }

    public int getMin(){
        int min=2147483647;
        for (int i=0;i<stack.size();i++){
            if (stack.get(i)<min)
                min=stack.get(i);
        }
        return min;
    }
}
