package search;

/**
 * @Author: Usher
 * @Description:
 */
public class MaxAreaofIsland {

    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] !=  1)
                    continue;
                int cnt = 0;
                dfs(grid, i, j, cnt, res);
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j,int cnt,int res) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        res = Math.max(res, cnt++);
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        for (int[] dir : dirs)
            dfs(grid, i + dir[0], j + dir[1], cnt, res);
    }
}
