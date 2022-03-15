package main.java.weekcompetition.week273;

/**
 * @author zhourup
 * @date 2021/12/26 10:33
 */
public class LeetCode5964 {

    public static void main(String[] args) {
        int[] res = executeInstructions(2, new int[]{1, 1}, "LURD");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = traverseMap(n, startPos, s.substring(i));
        }
        return res;
    }

    private static int traverseMap(int n, int[] startPos, String s) {
        int count = 0;
        int row = startPos[0], col = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                col -= 1;
            } else if (s.charAt(i) == 'R') {
                col += 1;
            } else if (s.charAt(i) == 'U') {
                row -= 1;
            } else if (s.charAt(i) == 'D') {
                row += 1;
            }
            if (row < 0 || col < 0 || row >= n || col >= n) {
                break;
            }
            count++;
        }
        return count;
    }
}
