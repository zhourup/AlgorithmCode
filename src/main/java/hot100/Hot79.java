package main.java.hot100;

public class Hot79 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board1 = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'},
        };
        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCEFSADEESE";
        System.out.println(exist(board2, word));

    }


    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        visited[i][j] = true;

        if (i > 0 && !visited[i - 1][j]) {
            flag1 = dfs(board, word, i - 1, j, index + 1, visited);
        }
        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            flag2 = dfs(board, word, i, j + 1, index + 1, visited);
        }
        if (i < board.length - 1 && !visited[i + 1][j]) {
            flag3 = dfs(board, word, i + 1, j, index + 1, visited);
        }
        if (j > 0 && !visited[i][j - 1]) {
            flag4 = dfs(board, word, i, j - 1, index + 1, visited);
        }
        if (flag1 || flag2 || flag3 || flag4) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
