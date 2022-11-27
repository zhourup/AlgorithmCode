package temp.autumn.nio;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] di = new int[n];
        for (int i = 0; i < n; i++) {
            di[i] = in.nextInt();
        }
        System.out.println(getMinWay(n, di));
    }

    private static int getMinWay(int n, int[] di) {
        int count = 0;
        while (!isComplete(di)) {
            int[] doq = findQu(di);
            for (int i = doq[0]; i < doq[1]; i++) {
                di[i]--;
            }
            count++;
        }
        return count;
    }

    private static boolean isComplete(int[] di) {
        for (int d : di) {
            if (d != 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] findQu(int[] di) {
        int[] res = new int[2];
        int start = 0;
        for (int i = 0; i < di.length; i++) {
            if (di[i] != 0) {
                start = i;
                break;
            }
        }
        int end = start;
        for (; end < di.length; end++) {
            if (di[end] == 0) {
                break;
            }
        }
        res[0] = start;
        res[1] = end;
        return res;
    }

}
