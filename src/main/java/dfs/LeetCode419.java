package main.java.dfs;

/**
 * @author zhourup
 * @date 2021/12/18 21:43
 */
public class LeetCode419 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
                {'.', '.', '.', '.'},
        };
        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        if (board[x][y] != 'X') {
            return;
        }
        board[x][y] = '.';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }
}
