package temp.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        cleanRoom(n, m, k, str);
    }


    private static void cleanRoom(int n, int m, int k, String str) {
        boolean[][] room = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(room[i], false);
        }
        int need = n * m - 1;
        room[0][0] = true;
        int currRow = 0;
        int currCol = 0;
        for (int i = 0; i < k; i++) {
            int[] next = getLocation(currRow, currCol, str.charAt(i));
            currRow = next[0];
            currCol = next[1];
            if (!room[currRow][currCol]) {
                need--;
                room[currRow][currCol] = true;
            }
            if (need == 0) {
                System.out.println("Yes");
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("No");
        System.out.println(need);
    }

    private static int[] getLocation(int row, int col, char c) {
        switch (c) {
            case 'W':
                return new int[]{row - 1, col};
            case 'A':
                return new int[]{row, col - 1};
            case 'S':
                return new int[]{row + 1, col};
            case 'D':
                return new int[]{row, col + 1};
            default:
        }
        return new int[]{row, col};
    }
}
