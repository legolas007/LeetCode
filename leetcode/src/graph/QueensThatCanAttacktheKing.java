package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/11/30,0030
 * @Description:
 */
public class QueensThatCanAttacktheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] exists = new boolean[8][8];
        int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dc = {0, 0, 1, -1, 1, -1, -1, 1};

        List<List<Integer>> ans = new LinkedList<>();

        // queens
        for (int[] queen : queens) {
            exists[queen[0]][queen[1]] = true;
        }

        for (int i = 0; i < 8; i++) {
            int r = king[0] + dr[i], c = king[1] + dc[i];

            while (r >= 0 && c >= 0 && r < 8 && c < 8) {
                if (exists[r][c]) {
                    ans.add(Arrays.asList(r, c));
                    break;
                }

                r = r + dr[i];
                c = c + dc[i];
            }
        }
        return ans;
    }
}
