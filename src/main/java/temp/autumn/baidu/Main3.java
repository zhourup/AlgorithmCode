package temp.autumn.baidu;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNext()) {
            String s = in.next();
            count += countObject(s);
        }
        System.out.println(count);
    }

    private static int countObject(String s) {
        System.out.println(s);

        System.out.println();
        return 1;
    }
}
