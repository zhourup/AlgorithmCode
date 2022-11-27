package temp.autumn.ant;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(getANum(x));
    }

    private static String getANum(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append('a');
        }
        if (x % 2 == 1) {
            int i = 0;
            while (!isFinish(sb)) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    char newC = (char) (sb.charAt(i) + 1);
                    sb.deleteCharAt(i + 1);
                    sb.setCharAt(i, newC);
                }
                i++;
                if (i + 1 == sb.length()) {
                    i = 0;
                }
            }
            return sb.toString();
        } else {
            int i = 0;
            while (!isFinish(sb)) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    char newC = (char) (sb.charAt(i) + 1);
                    sb.deleteCharAt(i + 1);
                    sb.setCharAt(i, newC);
                }
                i++;
                if (i == sb.length()) {
                    i = 0;
                }
            }
            return sb.toString();
        }
    }

    private static boolean isFinish(StringBuilder s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
}
