package dp;

/**
 * @Author: Usher
 * @Description:
 * f[i][j]最小值
 * f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
 * 上：f[i][j] = f[i-1][j] + grid[i][j];
 * 左：f[i][j] = f[i][j-1] + grid[i][j];
 * 初值：f[0][0] = grid[0][0]
 * f[0][j > 0] = f[0][j-1] + grid[0][j]//一行
 * f[i > 0][ 0] = f[i-1][0] + grid[i][0]//一列
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m+1][n+1];

        for(int i = 0;i < m;i++){
            for (int j =0;j < n;j++){
                if (i == 0){
                    if (j==0){
                        f[i][j] = grid[i][j];
                    }else {
                        f[i][j] = f[i][j-1] + grid[i][j];
                    }
                }else if (j == 0){
                    f[i][j] = f[i-1][j] + grid[i][j];
                }else {
                    f[i][j] = Math.min(f[i-1][j],f[i][j-1]) + grid[i][j];
                }
            }
        }
        return f[m-1][n-1];
    }
}
