package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/11/30,0030
 * @Description:
 */
public class CountServersthatCommunicate {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        Map<Integer, Integer> col = new HashMap<>(), row = new HashMap<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == 1) {
                    row.merge(y, 1, Integer::sum);
                    col.merge(x, 1, Integer::sum);
                }
            }
        }
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == 1 && row.get(y) > 1 || col.get(x) > 1) {
                    ans++;
                }
            }
        }

        return ans;
    }


}
