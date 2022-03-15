package main.java.queue;

public class LeetCode225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(5);
        int par2 = obj.pop();
        int par3 = obj.top();
        boolean par4 = obj.empty();
        System.out.println(par2);
        System.out.println(par3);
        System.out.println(par4);
    }
}
