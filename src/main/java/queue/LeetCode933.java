package main.java.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {

    private static Queue<Integer> queue1;

    public static void main(String[] args) {
        LeetCode933 leetCode933 = new LeetCode933();
        System.out.println(ping1(1));
        System.out.println(ping1(100));
        System.out.println(ping1(3001));
        System.out.println(ping1(3002));
    }

    public LeetCode933() {
        queue1 = new LinkedList<>();
    }

    public static int ping1(int t) {
        queue1.add(t);
        while (queue1.peek() < t - 3000)
            queue1.poll();
        return queue1.size();
    }
}
