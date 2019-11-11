package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Date: 2019/11/10,0010
 * @Description:
 */
public class CellswithOddValuesinaMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];

        int cnt = 0;
        for (int[] indice : indices) {
            help(matrix, indice);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void help(int[][] matrix, int[] indice) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == indice[0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += 1;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (i == indice[1]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] += 1;
                }
            }
        }

    }
}
