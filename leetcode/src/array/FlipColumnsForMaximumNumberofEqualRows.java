package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Usher
 * @Date: 2019/6/5/0005
 * @Description:
 *  [[0,0,0],
 *   [0,0,1],
 *   [1,1,0]]
 *   Find the i-th row, which has the most same or totaly different rows in the matrix.
 */
public class FlipColumnsForMaximumNumberofEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] flip = new int[n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                flip[j] = 1 - matrix[i][j];
            }

            for (int k = 0; k < m; k++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) {
                    cnt++;
                }
            }

            res = Math.max(res, cnt);
        }

        return res;
    }

    public int maxEqualRowsAfterFlips2(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for(int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for(int r : row) {
                sb1.append(r);
                sb2.append(1 - r);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            if(!map.containsKey(s1)) {
                map.put(s1, 1);
            } else {
                map.put(s1, map.get(s1) + 1);
            }
            if(!map.containsKey(s2)) {
                map.put(s2, 1);
            } else {
                map.put(s2, map.get(s2) + 1);
            }
        }
        int res = 0;
        for(int val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }
}
