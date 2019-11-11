package search;

/**
 * @Author: Usher
 * @Date: 2019/10/7,0007
 * @Description:
 * [[0, 6, 0],
 *  [5,8,7],
 *  [0,9,0]]
 */
public class PathwithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        int maxGold = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                maxGold = Math.max(maxGold, findMaxGold(grid, x, y, n, m));
            }
        }

        return maxGold;
    }

    private int findMaxGold(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[y][x] == 0) {
            return 0;
        }

        int originValue = grid[y][x];
        grid[y][x] = 0;

        int maxGold = 0;

        maxGold = Math.max(maxGold, findMaxGold(grid, x + 1, y, n, m));
        maxGold = Math.max(maxGold, findMaxGold(grid, x - 1, y, n, m));
        maxGold = Math.max(maxGold, findMaxGold(grid, x , y + 1, n, m));
        maxGold = Math.max(maxGold, findMaxGold(grid, x , y - 1, n, m));

        grid[y][x] = originValue;
        return maxGold + originValue;
    }
}
