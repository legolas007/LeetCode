package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class NQueensII {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] map = new int[n];
        dfs(map, 0, res);
        return res.size();
    }

    private static void dfs(int[] map, int row, List<List<String>> res) {
        final int N = map.length;
        if (row == N) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                char[] chars = new char[N];
                Arrays.fill(chars, '.');
                for (int j = 0; j < N; j++) {
                    if (j == map[i])
                        chars[j] = 'Q';
                }
                solution.add(new String(chars));
            }
            res.add(solution);
            return;
        }

        for (int j = 0; j < N; j++) {//扩展状态，一列列的试
            final boolean ok = isValid(map, row, j);
            if (!ok)//剪枝
                continue;
            //执行扩展动作
            map[row] = j;
            dfs(map, row+1, res);
        }
    }

    private static boolean isValid(int[] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            //同一列
            if (map[i] == col)
                return false;
            //同一对角线
            if (Math.abs(i-row) == Math.abs(map[i] - col))
                return false;
        }
        return true;
    }
}
