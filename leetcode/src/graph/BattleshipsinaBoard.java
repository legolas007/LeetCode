package graph;

/**
 * @Author: Usher
 * @Date: 2019/06/30,0030
 * @Description:
 */
public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }

        int n = board[0].length;
        int ans = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == 'X') {
                    ans++;
                    dfs(board, x, y, n, m);
                }
            }
        }

        return ans;
    }

    void dfs(char[][] board, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || board[y][x] == '.') {
            return;
        }
        board[y][x] = '.';//访问过标记，遍历其他相邻节点
        dfs(board, x + 1, y, n, m);
        dfs(board, x - 1, y, n, m);
        dfs(board, x, y+1, n, m);
        dfs(board, x, y-1, n, m);
    }
}
