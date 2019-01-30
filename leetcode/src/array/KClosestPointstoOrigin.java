package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Usher
 * @Date: 2019/1/15/0015
 * @Description:
 */
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));

        return Arrays.copyOfRange(points, 0, K);
    }
}
