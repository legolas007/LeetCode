package search;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/5/15/0015
 * @Description:
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for (int[] dir : dirs) {
                int x = tmp[0] + dir[0], y = tmp[1] + dir[1];
                if (x >=0 && x < m &&y >= 0 && y <n) {
                    if (matrix[x][y] > matrix[tmp[0]][tmp[1]] + 1) {
                        matrix[x][y] = matrix[tmp[0]][tmp[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }



            }
        }
        return matrix;
    }
}
