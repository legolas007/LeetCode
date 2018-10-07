package search;

/**
 * @Author: Usher
 * @Description:
 * 每个岛屿格子先默认加上四条边.左面和上面是否有岛屿格子，有的话分别减去两条边
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length,res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0 ;j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                res += 4;
                if (i > 0&& grid[i-1][j] == 1)
                    res -= 2;
                if (j > 0 && grid[i][j-1] == 1)
                    res -= 2;
            }
        }
        return res;
    }

}
