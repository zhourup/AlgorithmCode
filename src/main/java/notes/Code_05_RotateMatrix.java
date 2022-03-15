package main.java.notes;

public class Code_05_RotateMatrix {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 旋转打印矩阵
     *
     * @param m  矩阵
     * @param tR 初始顶点行
     * @param tC 初始顶点列
     * @param dR 目的顶点行
     * @param dC 目的顶点列
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= tR; i++) {
                System.out.print(m[tC][i] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[dR][tC]);
                curR--;
            }
        }
    }

    /**
     * 旋转矩阵90度
     *
     * @param m 矩阵
     * @param tR 初始顶点行
     * @param tC 初始顶点列
     * @param dR 目的顶点行
     * @param dC 目的顶点列
     */
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[dR + i][dC];
            m[dR + i][dC] = tmp;
        }
    }
}
