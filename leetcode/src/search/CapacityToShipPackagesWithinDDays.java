package search;

/**
 * @Author: Usher
 * @Date: 2019/5/29/0029
 * @Description:
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int start = Integer.MIN_VALUE, n = weights.length, sum = 0;

        for (int i = 0; i < n; i++) {
            start = Math.max(start, weights[i]);
            sum += weights[i];
        }

        start = Math.max(start, sum / D);
        for (int i = start; i <= sum ; i++) {
            int days = 0,curSum = 0;
            for (int j = 0; j < n; j++) {
                curSum += weights[j];
                if (curSum>i) {
                    curSum = weights[j];
                    days++;
                } else if (curSum == i) {
                    curSum = 0;
                    days++;
                }
            }

            if (curSum > 0) {
                days++;
            }

            if (days <= D) {
                return i;
            }
        }
        return -1;
    }
}
