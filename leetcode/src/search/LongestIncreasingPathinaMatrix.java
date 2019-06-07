package search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/6/5/0005
 * @Description:
 *
 */
public class LongestIncreasingPathinaMatrix {

    private int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int res = 1, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

    int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 1, m = matrix.length, n = matrix[0].length;

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];

            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j])
                continue;

            int len = dfs(matrix, dp, x, y) + 1;
            max = Math.max(max, len);
        }

        dp[i][j] = max;
        return max;
    }


    int dp[][];
    int m;
    int n;
    int res =1;

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        dp= new int[m][n];
        bfs(matrix);
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j ) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return  res;
    }

    void bfs(int[][] matrix){
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j ) {
                if (dp[i][j] > 0) continue;
                LinkedList<int []> queue = new  LinkedList<int []>();
                queue.addFirst(new int[]{i,j});
                int cnt = 1;
                dp[i][j]=1;
                while (queue.size()>0) {
                    ++cnt;
                    int len = queue.size();
                    for (int k = 0; k < len; ++k) {
                        int[] t = queue.removeLast();
                        for (int[] dir : dirs) {
                            int x = t[0] + dir[0], y = t[1] + dir[1];
                            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t[0]][t[1]] || cnt <= dp[x][y]) continue;
                            dp[x][y] = cnt;
                            res = Math.max(res, cnt);
                            queue.addFirst(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
