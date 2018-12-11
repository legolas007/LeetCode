package array;

/**
 * @Author: Usher
 * @Description:
 */
public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] tb = new int[grid.length];
        int[] lr = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                lr[i] = Integer.max(grid[i][j], lr[i]);
                tb[i] = Integer.max(grid[j][i], tb[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == tb[j] || grid[i][j] == lr[i])
                    continue;
                int min = Integer.min(tb[j], lr[i]);
                sum += min - grid[i][j];
            }
        }
        return sum;
    }
}
