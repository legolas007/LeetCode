package graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: Usher
 * @Date: 2019/9/1,0001
 * @Description:
 */
public class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        if(queue.size() == Math.pow(m,2)) return -1;
        int dis = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                dis = tmp[2];
                for (int[] dir : dirs) {
                    int x = tmp[0] + dir[0], y = tmp[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = dis + 1;
                        queue.offer(new int[]{x, y, dis + 1});
                    }
                }
            }
        }
        return dis;
    }

}
