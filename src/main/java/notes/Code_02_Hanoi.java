package main.java.notes;

/**
 * 汉诺塔问题
 */
public class Code_02_Hanoi {

    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            process(N - 1, from, to, help);
            System.out.println("Move " + N + " from " + from + " to " + to);
            process(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        process(3,"左","右","中");
    }
}
