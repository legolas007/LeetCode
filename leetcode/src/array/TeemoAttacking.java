package array;

/**
 * @Author: Usher
 * @Date: 2019/1/2/0002
 * @Description:
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            if (timeSeries[i]+ duration > timeSeries[i + 1]) {
                sum += timeSeries[i + 1] - timeSeries[i];
            } else {
                sum += duration;
            }
        }
        return sum + duration;
    }
}
