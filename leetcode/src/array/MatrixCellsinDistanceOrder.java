package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Usher
 * @Date: 2019/4/23/0023
 * @Description:
 */
public class MatrixCellsinDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];

        for (int i = 0, k = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {
                res[k++] =new int[]{i, j};
            }
        }


        Arrays.sort(res, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) -
                Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0));
        return res;
    }
}
