package search;

/**
 * @Author: Usher
 * @Date: 2019/1/30/0030
 * @Description:
 */
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int sx = -1, sy = -1;
        int n = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    n++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, n);
    }

    int dfs(int[][] grid, int sx,int sy,int n ) {
        if (sx < 0 || sx >= grid.length || sy < 0 || sy >= grid[0].length
                || grid[sx][sy] == -1) {
            return 0;
        }

        if (grid[sx][sy] == 2) {
            return n == 0 ? 1 : 0;
        }
        grid[sx][sy] = -1;

        int paths = dfs(grid, sx + 1, sy, n - 1) +
                dfs(grid, sx - 1, sy, n - 1) +
                dfs(grid, sx, sy + 1, n - 1) +
                dfs(grid, sx, sy - 1, n - 1);
        grid[sx][sy] = 0;

        return paths;
    }
}
