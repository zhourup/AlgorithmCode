package main.java.backtrack;

/**
 * @author zhourup
 * @date 2022/4/6 22:01
 */
public class LeetCode37 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            //穷举到最后一列的话就换到下一行重新开始
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            //找到一个可行解
            return true;
        }
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            //如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    //判断board[i][j]是否可以填下n
    private static boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == n) {
                return false;
            }
            if (board[i][c] == n) {
                return false;
            }
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
