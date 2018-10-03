package dp;

/**
 * @Author: Usher
 * @Description:
 * 边长由1变为2容易得知，即左上、左边以及上边的值均为1
 * 边长为3的正方形是由若干个边长为2的正方形堆叠得到的，这就是这道题的核心状态转移方程。
 *
 * 令状态dp[i][j]表示为从左上角(不一定是(0,0))到矩阵中坐标(i,j)为止能构成正方形的最大边长。那么有如下状态转移方程：
 *
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1; if matrix[i][j] == 1
 * dp[i][j] = 0; if matrix[i][j] = 0
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0||matrix[0].length==0) return 0;

        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j==0)
                    dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}
