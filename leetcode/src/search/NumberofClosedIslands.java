package search;

/**
 * @Author: Usher
 * @Date: 2019/11/23,0023
 * @Description:
 */
public class NumberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;

        int n = grid[0].length;

        int ans = 0;

        // 把边界相连的0变成1,剩下的就是被1包围的
        solve(grid);

        // 计算被1包围的island个数
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == 0) {
                    ans++;
                    dfs(grid, y, x);
                }
            }
        }
        return ans;
    }

    /**
     * 把边界相连的0变成1,剩下的就是被1包围的
     *
     * @param board
     */
    private void solve(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0
                        || j == board[i].length - 1) && board[i][j] == 0) {
                    dfs(board, i, j);
                }
            }
        }
    }

    public void dfs(int[][] board, int i, int j) {
        if (board[i][j] == 0) {
            board[i][j] = 1;
            if (i > 0 && board[i - 1][j] == 0)
                dfs(board, i - 1, j);
            if (j < board[i].length - 1 && board[i][j + 1] == 0)
                dfs(board, i, j + 1);
            if (i < board.length - 1 && board[i + 1][j] == 0)
                dfs(board, i + 1, j);
            if (j > 1 && board[i][j - 1] == 0)
                dfs(board, i, j - 1);
        }
    }
}
