package main.java.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhourup
 * @date 2022/4/2 20:44
 */
public class LeetCode51 {

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static List<List<String>> res;

    /**
     * N皇后问题
     * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    private static void backtrack(char[][] board, int row) {
        if (board.length == row) {
            res.add(chatToList(board));
            return;
        }
        int n = board.length;
        //依次在0到n-1列放置皇后
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            //做选择
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    /**
     * 是否可以在board[row][col]放置皇后
     */
    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //检查列是否有皇后互相冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> chatToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}
