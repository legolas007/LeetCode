package string;

/**
 * @Author: Usher
 * @Date: 2019/11/2,0002
 * @Description:
 */
public class CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] x = coordinates[0];
        int[] y = coordinates[1];

        double k1 = (y[1] - x[1]) * 1.0 / (y[0] - x[0]) * 1.0;

        for (int i = 2; i < coordinates.length; i++) {
            int[] point = coordinates[i];
            double k2 = (point[1] - y[1]) * 1.0 / (point[0] - y[0]) * 1.0;

            if (k1 != k2) {
                return false;
            }
        }
        return true;
    }
}
