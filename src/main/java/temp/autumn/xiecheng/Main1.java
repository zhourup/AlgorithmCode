package temp.autumn.xiecheng;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[][] str = new String[t][2];
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            str[i][0] = s1[0];
            str[i][1] = s1[1];
        }
        doProcess(str);
    }

    private static void doProcess(String[][] str) {
        int n = str.length;
        for (int i = 0; i < n; i++) {
            System.out.println(help(str[i]));
        }
    }

    private static String help(String[] s) {
        if (isCanDo(s[0], s[1])) {
            return "Yes";
        }
        return "No";
    }

    private static boolean isCanDo(String s1, String s2) {
        int count = 0;
        char c1 = '1';
        char c2 = '1';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (count == 2) {
                return false;
            }
            if (count == 0) {
                c1 = s1.charAt(i);
                c2 = s2.charAt(i);
            }
            if (count == 1) {
                if (s1.charAt(i) != c2 || s2.charAt(i) != c1) {
                    return false;
                }
            }
            count++;
        }
        return count == 2;
    }
}
