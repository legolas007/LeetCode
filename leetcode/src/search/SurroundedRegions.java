package search;

/**
 * @Author: Usher
 * @Description:
 * 扫面矩阵的四条边，如果有O，则用DFS遍历，将所有连着的O都变成另一个字符，比如，这样剩下的O都是被包围的，然后将这些O变成X，把变回O就行了
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'Q')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = 'Q';
            if (i > 0&& board[i-1][j] == 'O')
                dfs(board, i - 1, j);
            if (j < board[i].length-1&&board[i][j+1] == 'O')
                dfs(board,i,j+1);
            if (i < board.length-1&&board[i+1][j] == 'O')
                dfs(board, i + 1, j);
            if (j > 1 && board[i][j-1] == 'O')
                dfs(board, i, j - 1);
        }
    }
}
