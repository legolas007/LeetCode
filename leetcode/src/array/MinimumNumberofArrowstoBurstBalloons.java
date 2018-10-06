package array;

import java.util.Arrays;

/**
 * @Author: Usher
 * @Description:从points中的第一个气球开始，遍历points数组，如果第 i 个气球和前 i-1 个气球都有重叠，则它们是可以在一次射击里被一起扎破的；直到出现某个气球与它之前的某个气球完全不重叠，表示需要射出另外一支箭
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length ==0)
            return 0;
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int sum= 1;
        int endIndex = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= endIndex) {
                endIndex = Math.min(endIndex, points[i][1]);
            } else {
                sum++;
                endIndex = points[i][1];
            }
        }
        return sum;
    }
}
