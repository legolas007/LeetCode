package dp;

/**
 * @Author: Usher
 * @Description:
 * dp[s][i][j] = dp[s-1][i+1][j] +
 * dp[s-1][i-1][j] +
 * dp[s-1][i][j+1] +
 * dp[s-1][i][j-1]
 */
public class OutofBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        final int mod = 1000000000 + 7;
        int[][][] dp = new int[N + 1][m][n];

        int[] dirs = {-1, 0, 1, 0, -1};

        for (int s = 1; s <= N; s++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int d = 0; d < 4; d++) {
                        int tx = x + dirs[d];
                        int ty = y + dirs[d + 1];

                        if (tx < 0 || ty < 0 || tx >= m || ty >= n) {
                            dp[s][x][y] += 1;
                        } else {
                            dp[s][x][y] = (dp[s][x][y] + dp[s - 1][tx][ty]) % mod;
                        }
                    }
                }
            }
        }
        return dp[N][i][j];
    }
}
