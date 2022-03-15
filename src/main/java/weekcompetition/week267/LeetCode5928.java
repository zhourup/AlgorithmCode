package main.java.weekcompetition.week267;

/**
 * @author zhourup
 * @date 2021/11/14 11:56
 */
public class LeetCode5928 {

    public static void main(String[] args) {
        String s = "ch   ie   pr";
        int rows = 3;
        System.out.println(decodeCiphertext(s, rows));
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        char[][] chars = new char[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = encodedText.charAt(count++);
            }
        }
        StringBuilder sb = new StringBuilder();
        int row = 0, col = 0, nextCol = 1;
        while (col < cols) {
            sb.append(chars[row++][col++]);
            if (row == rows) {
                row = 0;
                col = nextCol++;
            }
        }
        String res = sb.toString();
        int index = res.length() - 1;
        while (index >= 0) {
            if (res.charAt(index) == ' ') {
                index--;
            } else {
                break;
            }
        }
        return res.substring(0, index + 1);
    }
}
