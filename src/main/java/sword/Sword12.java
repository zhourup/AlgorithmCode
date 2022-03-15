package main.java.sword;

/**
 * @author zhourup
 * @date 2022/3/10 20:47
 */
public class Sword12 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existPlus(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断从board[i][j]开始有无word
     *
     * @param board
     * @param words
     * @param i
     * @param j
     * @param index
     * @return
     */
    private static boolean existPlus(char[][] board, char[] words, int i, int j, int index) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != words[index]) {
            return false;
        }
        if (index == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = existPlus(board, words, i - 1, j, index + 1) || existPlus(board, words, i + 1, j, index + 1) ||
                existPlus(board, words, i, j + 1, index + 1) || existPlus(board, words, i, j - 1, index + 1);
        board[i][j] = words[index];
        return res;
    }
}
