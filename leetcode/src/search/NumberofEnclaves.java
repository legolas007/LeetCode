package search;

/**
 * @Author: Usher
 * @Date: 2019/5/16/0016
 * @Description:
 *  [[0,0,0,0],
 *  [1,0,1,0],
 *  [0,1,1,0],
 *  [0,0,0,0]]
 */
public class NumberofEnclaves {
    public int numEnclaves(int[][] A) {

        int m = A.length, n = A[0].length;
        int sum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //从边界开始搜索
                if (A[i][j] == 1 && i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    dfs(A, i, j, m, n);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (A[i][j] == 1) {
                    sum++;
                }
            }
        }

        return sum;
    }

    private void dfs(int[][] grid,int x,int y,int m,int n){
        if (x >= 0 && y >=0 && x <= m -1 && y <= n -1 && grid[x][y] == 1) {
            grid[x][y] = 0;//访问过标记0，遍历其他相邻节点
            dfs(grid, x + 1, y, m, n);
            dfs(grid, x - 1, y, m, n);
            dfs(grid, x, y + 1, m, n);
            dfs(grid, x, y - 1, m, n);
        }
    }
}
