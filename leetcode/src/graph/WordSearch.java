package graph;

/**
 * @Author: Usher
 * @Date: 2019/1/5/0005
 * @Description:
 * 深度优先遍历DFS
 * 如果二维数组board的当前字符和目标字符串word对应的字符相等，则对其上下左右四个邻字符分别调用DFS的递归函数，
 * 只要有一个返回true，那么就表示可以找到对应的字符串，否则就不能找到
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length ==0)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board,word,0,i,j))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length
                || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, word, idx + 1, i - 1, j)
                || dfs(board, word, idx + 1, i + 1, j)
                || dfs(board, word, idx + 1, i, j - 1)
                || dfs(board, word, idx + 1, i, j + 1);
        board[i][j] = c;
        return res;
    }
}
