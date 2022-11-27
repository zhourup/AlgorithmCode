package temp.autumn.wangyi;

import java.util.Scanner;

/**
 * 输入n,输出包含25数的个数
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(prepareNum(n));
    }

    private static int prepareNum(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isContain(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isContain(int num) {
        String n = String.valueOf(num);
        return n.contains("25");
    }
}
