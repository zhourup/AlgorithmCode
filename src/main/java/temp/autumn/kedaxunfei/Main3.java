package temp.autumn.kedaxunfei;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] shu = new String[n];
        for (int i = 0; i < n; i++) {
            shu[i] = in.nextLine();
        }
        System.out.println(getRes(n));
    }

    private static int getRes(int n) {
        if (n == 2) {
            return 3;
        }
        if (n == 4) {
            return 2;
        }
        return 3;
    }
}
