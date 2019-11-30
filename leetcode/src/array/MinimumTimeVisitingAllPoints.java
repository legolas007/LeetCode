package array;

/**
 * @Author: Usher
 * @Date: 2019/11/30,0030
 * @Description:
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int cnt = 0;
        if (points.length <= 1) {
            return 0;
        }

        for (int i = 1; i < points.length; i++) {
            cnt += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }

        return cnt;
    }
}
