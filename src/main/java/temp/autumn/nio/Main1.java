package temp.autumn.nio;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        getValue(d);
    }

    private static void getValue(int d) {
        int count = 0;
        for (int i = 1; i < d; i++) {
            int temp = i + d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(temp);
            String str2 = sb2.reverse().toString();
            StringBuilder sb1 = new StringBuilder();
            sb1.append(i);
            String str1 = sb1.toString();
            if (str1.equals(str2)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
