package temp.autumn.didi;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(getRes(s));
    }

    private static String getRes(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        // 先对第一个处理
        if (s.charAt(0) == '?') {
            for (int i = 1; i < 9; i++) {
                char ic = tran(i);
                if (n > 1 && s.charAt(1) != ic) {
                    sb.append(i);
                    break;
                }
            }
        } else {
            sb.append(s.charAt(0));
        }

        // 对中间处理
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '?') {
                if (i + 1 < n - 1 && s.charAt(i + 1) != '?') {
                    for (int k = 0; k <= 9; k++) {
                        char pre = s.charAt(i - 1);
                        char last = s.charAt(i + 1);
                        char ic = tran(k);
                        if (ic != pre && ic != last) {
                            sb.append(ic);
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < 9; k++) {
                        char ic = tran(k);
                        if (s.charAt(i - 1) != ic) {
                            sb.append(ic);
                            break;
                        }
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        // 对最后一个处理
        if (s.charAt(n - 1) == '?') {
            char pre = s.charAt(n - 2);
            for (int i = 0; i <= 9; i++) {
                char ic = tran(i);
                if (ic != pre && isValid(sb, ic)) {
                    sb.append(i);
                    break;
                }
            }
        } else {
            sb.append(s.charAt(n - 1));
        }
        return sb.toString();
    }

    private static boolean isValid(StringBuilder sb, char c) {
        sb.append(c);
        String s = sb.toString();
        Long b = Long.parseLong(s);
        if (b % 3 == 0) {
            sb.deleteCharAt(sb.length() - 1);
            return true;
        }

        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    private static char tran(int i) {
        String s = String.valueOf(i);
        char[] str = s.toCharArray();
        return str[0];
    }
}
